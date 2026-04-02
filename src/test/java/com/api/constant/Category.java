package com.api.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
	HOME,WORK,PERSONAL;

	@JsonValue
    public String toString() {
        String name = this.name();
        return name.substring(0, 1) + name.substring(1).toLowerCase();
    }
}
