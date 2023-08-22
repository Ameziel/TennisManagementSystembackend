package tms.tennismanagementsystem.app.inscriptionsformule;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class InscriptionFormuleMapperImplementation {

    public InscriptionFormuleDTO fromInscriptionFormuleEntity(InscriptionFormuleEntity inscriptionFormuleEntity) {
        InscriptionFormuleDTO inscriptionFormuleDTO = new InscriptionFormuleDTO();
        BeanUtils.copyProperties(inscriptionFormuleEntity, inscriptionFormuleDTO);
        return inscriptionFormuleDTO;
    }
    public InscriptionFormuleEntity fromInscriptionFormuleDTO(InscriptionFormuleDTO inscriptionFormuleDTO){
        InscriptionFormuleEntity inscriptionFormuleEntity = new InscriptionFormuleEntity();
        BeanUtils.copyProperties(inscriptionFormuleDTO, inscriptionFormuleEntity);
        return inscriptionFormuleEntity;
    }
}
