package com.o3.codingtest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ApiResponseUtil {

    public static class ApiResponse<T> {
        private final int status;
        private final String error;
        private final T result;

        public ApiResponse(int status, String error, T result) {
            this.status = status;
            this.error = error;
            this.result = result;
        }

        public int getStatus() {
            return status;
        }

        public String getError() {
            return error;
        }

        public T getResult() {
            return result;
        }
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {
        ApiResponse<T> response = new ApiResponse<>(HttpStatus.OK.value(), message, data);
        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(HttpStatus status, String message) {
        ApiResponse<T> response = new ApiResponse<>(status.value(), message, null);
        return ResponseEntity.status(status).body(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> conflict(String message) {
        return error(HttpStatus.CONFLICT, message);
    }
    public static <T> ResponseEntity<ApiResponse<T>> notFound(String message) {
        return error(HttpStatus.NOT_FOUND, message);
    }

    public static <T> ResponseEntity<ApiResponse<T>> unauthorized(String message) {
        return error(HttpStatus.UNAUTHORIZED, message);
    }

    public static <T> ResponseEntity<ApiResponse<T>> internalServerError(String message) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public static <T> ResponseEntity<ApiResponse<T>> handleApi(ApiCall<T> call) {
        try {
            T result = call.invoke();
            return success(result, null);
        } catch (CustomNotFoundException ex) {
            return notFound(ex.getMessage());
        } catch (CustomUnauthenticatedException ex) {
            return unauthorized(ex.getMessage());
        } catch (CustomConflictException ex) {
            return conflict(ex.getMessage());
        } catch (Exception ex) {
            return internalServerError(ex.getMessage());
        }
    }

    public interface ApiCall<T> {
        T invoke() throws Exception;
    }

    public static class CustomNotFoundException extends RuntimeException {
        public CustomNotFoundException(String error) {
            super(error);
        }
    }

    public static class CustomUnauthenticatedException extends RuntimeException {
        public CustomUnauthenticatedException(String error) {
            super(error);
        }
    }
    public static class CustomConflictException extends RuntimeException {
        public CustomConflictException(String error) {super(error); }
    }
}
