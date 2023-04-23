package com.github.saintedlittle.json.model;

import com.fasterxml.jackson.annotation.*;
import java.util.UUID;

@lombok.Data
public class BannedPlayers {
    @lombok.Getter(onMethod_ = {@JsonProperty("uuid")})
    @lombok.Setter(onMethod_ = {@JsonProperty("uuid")})
    private UUID uuid;
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("created")})
    @lombok.Setter(onMethod_ = {@JsonProperty("created")})
    private String created;
    @lombok.Getter(onMethod_ = {@JsonProperty("source")})
    @lombok.Setter(onMethod_ = {@JsonProperty("source")})
    private String source;
    @lombok.Getter(onMethod_ = {@JsonProperty("expires")})
    @lombok.Setter(onMethod_ = {@JsonProperty("expires")})
    private String expires;
    @lombok.Getter(onMethod_ = {@JsonProperty("reason")})
    @lombok.Setter(onMethod_ = {@JsonProperty("reason")})
    private String reason;
}