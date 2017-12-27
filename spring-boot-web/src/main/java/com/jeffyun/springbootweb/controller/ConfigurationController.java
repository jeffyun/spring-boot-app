package com.jeffyun.springbootweb.controller;

import com.jeff.springbootmybatis.mapper.ConfigurationMapper;
import com.jeff.springbootmybatis.model.Configuration;
import com.jeffyun.springbootweb.model.CommonResponse;
import com.sun.xml.internal.ws.wsdl.writer.document.ParamType;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeff on 2017/12/22.
 */
@RestController
@RequestMapping(value = "/configuration")
@Api(value = "/configuration",description = "测试接口")
public class ConfigurationController {

    @Autowired
    private ConfigurationMapper configurationMapper;

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200,message = "对象参数",response = CommonResponse.class)})
    @ApiOperation(value = "查询配置信息集合列表")
    public @ResponseBody CommonResponse listConfiguration() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(1);
        commonResponse.setData(configurationMapper.selectAll());
        return commonResponse;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键ID",paramType ="path",dataType = "int")
    })
    @ApiOperation(value = "主键ID查询配置信息")
    public @ResponseBody CommonResponse<Configuration> getConfigurationById(@PathVariable Integer id){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(1);
        commonResponse.setData(configurationMapper.selectByPrimaryKey(id));
        return commonResponse;
    }
}
