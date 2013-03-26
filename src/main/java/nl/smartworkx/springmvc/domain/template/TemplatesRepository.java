package nl.smartworkx.springmvc.domain.template;

import nl.smartworkx.springmvc.infra.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TemplatesRepository extends BaseRepository<Template> {

    public Class<Template> getDomainClass(){
        return Template.class;
    }
}
