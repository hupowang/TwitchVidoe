package com.laioffer.jupiter.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
// indicates that other fields in the response can be safely ignored.
// Without this, you’ll get an exception at runtime.
@JsonInclude(JsonInclude.Include.NON_NULL)
//indicates that null fields can be skipped and not included.
@JsonDeserialize(builder = Game.Builder.class)
//JsonDeserialize indicates that Jackson needs to use Game.
//Builder when constructing a Game object from JSON strings.

public class Game {
    private final String id;

    private final String name;

    //matching 讲filed的名字和Json里关联起来
    @JsonProperty("box_art_url")
    private final String boxArtUrl;

    private Game(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.boxArtUrl = builder.boxArtUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBoxArtUrl() {
        return boxArtUrl;
    }


    //什么时候用Builder？可以只负责去call感兴趣的类初始化。
    //去查一下builder pattern：设计模式
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Builder {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("box_art_url")
        private String boxArtUrl;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder boxArtUrl(String boxArtUrl) {
            this.boxArtUrl = boxArtUrl;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}

