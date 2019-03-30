package com.eiv.poc.apiweb.oauth2;

public class OAuth2TokensInfo {

    private String accessToken;
    private String refreshToken;
    
    public OAuth2TokensInfo() {
    }
    
    public OAuth2TokensInfo(String accessToken) {
        this(accessToken, null);
    }

    public OAuth2TokensInfo(String accessToken, String refreshToken) {
        super();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accessToken == null) ? 0 : accessToken.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OAuth2TokensInfo other = (OAuth2TokensInfo) obj;
        if (accessToken == null) {
            if (other.accessToken != null)
                return false;
        } else if (!accessToken.equals(other.accessToken))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OAuth2TokensInfo [accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
    }
    
}
