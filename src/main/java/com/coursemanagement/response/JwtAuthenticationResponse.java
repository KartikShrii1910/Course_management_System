package com.coursemanagement.response;



public class JwtAuthenticationResponse {

    private String accessToken;
    private String tokenType = "Bearer";
//    private String role;

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

//    public JwtAuthenticationResponse(String accessToken, String role) {
//		super();
//		this.accessToken = accessToken;
//		this.role = role;
//	}

	public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

//    public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}

	public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
 