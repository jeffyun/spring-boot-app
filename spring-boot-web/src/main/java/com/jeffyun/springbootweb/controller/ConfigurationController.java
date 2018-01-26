package com.jeffyun.springbootweb.controller;

import com.jeffyun.common.model.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeff on 2017/12/22.
 */
@RestController
@RequestMapping(value = "/configuration")
@Api(value = "/configuration",description = "测试接口")
public class ConfigurationController {


    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200,message = "对象参数",response = CommonResponse.class)})
    @ApiOperation(value = "查询配置信息集合 列表")
    public @ResponseBody CommonResponse listConfiguration() {
        return CommonResponse.RESPONSE_OK;
    }

//
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id",value = "主键ID",paramType ="path",dataType = "int")
//    })
//    @ApiOperation(value = "主键ID查询配置信息")
//    public @ResponseBody CommonResponse<> getConfigurationById(@PathVariable Integer id){
//        CommonResponse commonResponse = new CommonResponse();
//        commonResponse.setCode(1);
//        commonResponse.setData(configurationMapper.selectByPrimaryKey(id));
//        return commonResponse;
//    }
}
