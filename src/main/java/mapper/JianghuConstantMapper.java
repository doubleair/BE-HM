package mapper;

import dataObject.JianghuConstantDO;
import model.JianghuConstantModel;
import org.springframework.stereotype.Repository;

/**
 * 类MarkConstantMapper.java的实现描述：TODO 类实现描述 
 * @author jizhi.qy 2017年11月27日 下午9:27:17
 */
@Repository
public class JianghuConstantMapper implements Mapper<JianghuConstantModel, JianghuConstantDO> {

    @Override
    public JianghuConstantDO toDO(JianghuConstantModel m) {
        JianghuConstantDO d = new JianghuConstantDO();
        d.setId(m.getId());
        d.setName(m.getName());
        d.setCnName(m.getCnName());
        d.setCategory(m.getCategory());
        return d;
    }

    @Override
    public JianghuConstantModel toModel(JianghuConstantDO d) {
        JianghuConstantModel m = new JianghuConstantModel();
        m.setId(d.getId());
        m.setCnName(d.getCnName());
        m.setName(d.getName());
        m.setCategory(d.getCategory());
        return m;
    }

}
