package com.controller;

import com.annotation.Admin;
import com.pojo.Organization;
import com.service.OrganizationService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Organization")
@CrossOrigin
public class OrganizationController {
    @Autowired
    private R r;
    @Autowired
    private OrganizationService OrganizationService;

    @RequestMapping(value = "/ShowOrganizationInfoLimit",method = RequestMethod.GET)
    public R showOrganizationInfo(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "100") Integer pageSize)
    {
        List<Organization> organizations = OrganizationService.queryOrganizationLimit((pageNum-1)*pageSize,pageSize);
        return r.success(organizations);
    }

    @RequestMapping(value ="/AddOrganization",method = RequestMethod.POST)
    @Admin
    public R addNewStaff(@RequestBody Organization organization) {
        int result = OrganizationService.addNewOrganization(organization);
        return result > 0 ? r.success():r.error();
    }

    @RequestMapping(value = "/DeleteOrganization/{organizationId}",method = RequestMethod.DELETE)
    @Admin
    public R deleteStaff(@PathVariable("organizationId") int organizationId) {
        return r.success(OrganizationService.deleteOrganizationById(organizationId));
    }

    @RequestMapping(value ="/UpdateOrganization",method = RequestMethod.POST)
    @Admin
    public R updateOrganization(@RequestBody Organization organization) {
        int result = OrganizationService.UpdateOrganization(organization);
        return result > 0 ? r.success():r.error();
    }

    @RequestMapping(value ="/ShowOrganizationById",method = RequestMethod.GET)
    public R showOrganizationById(@RequestBody int organizationId) {
        Organization organization = OrganizationService.queryOrganizationById(organizationId);
        return r.success(organization);
    }
}
