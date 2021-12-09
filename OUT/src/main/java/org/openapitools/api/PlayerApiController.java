package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T21:04:10.402+01:00[Europe/Belgrade]")
@Controller
@RequestMapping("${openapi.userCRUD.base-path:}")
public class PlayerApiController implements PlayerApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PlayerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
