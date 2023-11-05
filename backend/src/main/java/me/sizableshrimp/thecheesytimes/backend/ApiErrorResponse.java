
package me.sizableshrimp.thecheesytimes.backend;

import org.springframework.http.HttpStatus;

public record ApiErrorResponse(int code, String message) {
    public static ApiErrorResponse resourceNotFound() {
        return new ApiErrorResponse(HttpStatus.NOT_FOUND.value(), "Resource not found");
    }
}
