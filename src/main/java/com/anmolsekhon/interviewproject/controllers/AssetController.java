package com.anmolsekhon.interviewproject.controllers;

import com.anmolsekhon.interviewproject.domain.Asset;
import com.anmolsekhon.interviewproject.domain.JwtRequest;
import com.anmolsekhon.interviewproject.domain.JwtResponse;
import com.anmolsekhon.interviewproject.services.AssetService;
import com.anmolsekhon.interviewproject.services.UserService;
import com.anmolsekhon.interviewproject.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller Layer - contains all API endpoints (GET, POST, PUT, DELETE)
 */

@CrossOrigin // Allow cross-origin requests
@RestController
@RequestMapping("v1/asset")
public class AssetController {

    //    Annotation Dependency Injection
    @Autowired
    private AssetService assetService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtility jwtUtility;

    //    Retrieve Operation - will handle all GET Requests
    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    //    Create Operation - will handle all POST Requests
    @PostMapping
    public void saveAsset(@RequestBody Asset asset) {
        assetService.saveAsset(asset);
    }

    //    Delete Operation - will handle all deletion requests
    //    this method also requires an assetId in API url
    @DeleteMapping("{assetId}")
    public void deleteAsset(@PathVariable Long assetId) {
        assetService.deleteAsset(assetId);
    }

    //    Update Operation - will handle all update requests
    @PutMapping("{assetId}")
    public void updateAsset(
            @PathVariable() Long assetId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Double priceValue,
            @RequestParam(required = false) Long assetTypeId
    ) {
        assetService.updateAsset(assetId, name, description, priceValue, assetTypeId);
    }

    /**
     * a POST method with end point '/v1/asset/authenticate'
     * this will take username and password from the user in 'application/json' format.
     * It will try to authenticate the user and issue a JWT token if credentials match
     */
    @PostMapping("authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtRequest.getUsername(),
                    jwtRequest.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials", e);
        }

        final UserDetails userDetails =
                userService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);
        return new JwtResponse(token);
    }
}
