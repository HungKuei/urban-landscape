package com.urban.service.impl;

import com.urban.core.AbstractService;
import com.urban.core.TypeEnum;
import com.urban.mapper.EnterpriseMapper;
import com.urban.mapper.QualificationMapper;
import com.urban.model.Enterprise;
import com.urban.model.Qualification;
import com.urban.model.vo.QueryParamVO;
import com.urban.service.EnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnterpriseServiceImpl extends AbstractService<Enterprise> implements EnterpriseService {

    @Resource
    private EnterpriseMapper enterpriseMapper;

    @Resource
    private QualificationMapper qualificationMapper;

    @Override
    public List<Enterprise> getPageListByQueryParam(QueryParamVO queryParamVO) {
        return enterpriseMapper.selectByQueryParam(queryParamVO);
    }

    @Override
    public List<Enterprise> getAllList() {
        List<Enterprise> enterprises = enterpriseMapper.selectAll();
        if (!enterprises.isEmpty()){
            for (Enterprise enterprise : enterprises){
                List<Qualification> qualifications = qualificationMapper.selectByEnterpriseName(enterprise.getEnterpriseName());
                if (qualifications.isEmpty()){
                    continue;
                }
                String quety = "";
                for (Qualification qualification : qualifications){
                    String typeName = TypeEnum.getTypeNameByCode(qualification.getType());
                    quety += typeName + "：" + qualification.getLevel() + " ";
                }
                enterprise.setQualification(quety);
            }
        }
        return enterprises;
    }
}
