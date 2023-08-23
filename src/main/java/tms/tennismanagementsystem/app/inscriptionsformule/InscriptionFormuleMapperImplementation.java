package tms.tennismanagementsystem.app.inscriptionsformule;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tms.tennismanagementsystem.app.eleves.EleveEntity;
import tms.tennismanagementsystem.app.formulecours.FormuleCoursEntity;
import tms.tennismanagementsystem.app.groupescours.GroupeCoursEntity;

@Service
public class InscriptionFormuleMapperImplementation {

    public InscriptionFormuleDTO fromInscriptionFormuleEntity(InscriptionFormuleEntity inscriptionFormuleEntity) {
        InscriptionFormuleDTO inscriptionFormuleDTO = new InscriptionFormuleDTO();
        BeanUtils.copyProperties(inscriptionFormuleEntity, inscriptionFormuleDTO);

        inscriptionFormuleDTO.setReferenceEleve(inscriptionFormuleEntity.getReferenceEleve().getId());
        inscriptionFormuleDTO.setReferenceGroupeCours(inscriptionFormuleEntity.getReferenceGroupe().getId());
        inscriptionFormuleDTO.setReferenceFormuleCours(inscriptionFormuleEntity.getReferenceFormuleCours().getId());
        return inscriptionFormuleDTO;
    }
    public InscriptionFormuleEntity fromInscriptionFormuleDTO(InscriptionFormuleDTO inscriptionFormuleDTO){
        InscriptionFormuleEntity inscriptionFormuleEntity = new InscriptionFormuleEntity();
        BeanUtils.copyProperties(inscriptionFormuleDTO, inscriptionFormuleEntity);

        EleveEntity temp_eleve = new EleveEntity();
        temp_eleve.setId(inscriptionFormuleDTO.getReferenceEleve());
        inscriptionFormuleEntity.setReferenceEleve(temp_eleve);

        GroupeCoursEntity temp_groupeCours = new GroupeCoursEntity();
        temp_groupeCours.setId(inscriptionFormuleDTO.getReferenceGroupeCours());
        inscriptionFormuleEntity.setReferenceGroupe(temp_groupeCours);

        FormuleCoursEntity temp_formuleCours = new FormuleCoursEntity();
        temp_formuleCours.setId(inscriptionFormuleDTO.getReferenceFormuleCours());
        inscriptionFormuleEntity.setReferenceFormuleCours(temp_formuleCours);

        return inscriptionFormuleEntity;
    }
}
