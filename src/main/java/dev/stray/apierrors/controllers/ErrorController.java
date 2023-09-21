package dev.stray.apierrors.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController()
@RequestMapping("/errors")
public class ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    @GetMapping("/healthy")
    public ResponseEntity<String> getHealthyStatus() {
        LOGGER.info("Get healthy status");
        return new ResponseEntity<>("Application is healthy", HttpStatus.OK);
    }

    /**
     * TODO: make sure thrown object gets morphed into HTTP problem response structure
     * @return
     * @throws Exception
     */
    @GetMapping("/throw")
    public ResponseStatusException getThrownError() throws Exception {
        LOGGER.info("Get thrown error");
        throw new Exception("Get thrown error");
    }

    @GetMapping("/400")
    public ResponseStatusException getBadRequestError() {
        LOGGER.info("Get bad request error");
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Get bad request error");
    }

    @GetMapping("/401")
    public ResponseStatusException getUnauthorizedError() {
        LOGGER.info("Get unauthorized error");
        return new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Get unauthorized error");
    }

    @GetMapping("/403")
    public ResponseStatusException getForbiddenError() {
        LOGGER.info("Get forbidden error");
        return new ResponseStatusException(HttpStatus.FORBIDDEN, "Get forbidden error");
    }

    @GetMapping("/404")
    public ResponseStatusException getNotFoundError() {
        LOGGER.info("Get not found error");
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Get not found error");
    }

    @GetMapping("/409")
    public ResponseStatusException getConflictError() {
        LOGGER.info("Get conflict error");
        return new ResponseStatusException(HttpStatus.CONFLICT, "Get conflict error");
    }

    @GetMapping("/500")
    public ResponseStatusException getInternalServerError() {
        LOGGER.info("Get internal server error");
        return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Get internal server error");
    }

    @GetMapping("/502")
    public ResponseStatusException getBadGatewayError() {
        LOGGER.info("Get bad gateway error");
        return new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Get bad gateway error");
    }

    @GetMapping("/503")
    public ResponseStatusException getServiceUnavailableError() {
        LOGGER.info("Get service unavailable error");
        return new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Get service unavailable error");
    }
}
