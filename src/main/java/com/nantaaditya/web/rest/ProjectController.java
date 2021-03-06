package com.nantaaditya.web.rest;

import com.nantaaditya.helper.impl.ControllerHelper;
import com.nantaaditya.helper.impl.ResponseHelper;
import com.nantaaditya.model.EmptyRequest;
import com.nantaaditya.model.EmptyResponse;
import com.nantaaditya.model.Response;
import com.nantaaditya.model.command.GetProjectCommandResponse;
import com.nantaaditya.model.command.SaveProjectCommandRequest;
import com.nantaaditya.model.web.GetProjectWebResponse;
import com.nantaaditya.model.web.SaveProjectWebRequest;
import com.nantaaditya.properties.ApiPath;
import com.nantaaditya.service.command.DeleteProjectCommand;
import com.nantaaditya.service.command.GetProjectCommand;
import com.nantaaditya.service.command.SaveProjectCommand;
import com.nantaaditya.web.AbstractController;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

@Slf4j
@RestController
@RequestMapping(value = ApiPath.PROJECT)
public class ProjectController extends AbstractController {

  @Autowired
  private ControllerHelper controllerHelper;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Response<EmptyResponse> save(@RequestParam String requestId,
      @RequestBody SaveProjectWebRequest webRequest) {
    return controllerHelper.response(SaveProjectCommand.class,
        convertRequest(webRequest, new SaveProjectCommandRequest()),
        requestId,"save project success");
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Response<List<GetProjectWebResponse>> get(@RequestParam String requestId) {
    List<GetProjectCommandResponse> response = controllerHelper.response(
        GetProjectCommand.class, EmptyRequest.getInstance());
    return ResponseHelper.ok(requestId, "get project success",
        convertResponse(response, GetProjectWebResponse.class));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Response<EmptyResponse> delete(@RequestParam String requestId, @PathVariable String id) {
    return controllerHelper
        .response(DeleteProjectCommand.class, id, requestId, "delete project success");
  }

}
