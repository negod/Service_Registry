package se.backede.service.registry.entity;

import com.negod.generics.persistence.entity.GenericEntity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;
import se.backede.service.registry.constants.EntityConstants;


/**
 *
 * @author Joakim Backede joakim.backede@outlook.com
 */
@Entity
@Getter
@Setter
@Indexed
@Cacheable
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.NONE)
@Table(name = EntityConstants.Registry)
@XmlRootElement(name = EntityConstants.Registry)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = EntityConstants.Registry)
@AnalyzerDef(name = "registry_customanalyzer",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
            @TokenFilterDef(factory = LowerCaseFilterFactory.class)
        })
public class RegistryEntity extends GenericEntity {

    @Analyzer(definition = "registry_customanalyzer")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    @Column(name = "serviceName", insertable = true, unique = true)
    @XmlElement
    private String serviceName;
    
    @Analyzer(definition = "registry_customanalyzer")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    @Column(name = "url", insertable = true, unique = true)
    @XmlElement
    private String url;
    
    @Analyzer(definition = "registry_customanalyzer")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    @Column(name = "definition", insertable = true, unique = true)
    @XmlElement
    private String definition;

//    @ContainedIn
//    @XmlElement
//    @IndexedEmbedded(depth = 3)
//    @OneToOne(mappedBy = "registry", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
//    private RegistryDetailEntity detail;
//
//    @ContainedIn
//    @XmlElement
//    @IndexedEmbedded(depth = 3)
//    @JoinColumn(serviceName = "domain_id", referencedColumnName = "id")
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private DomainEntity domain;
//
//    @ContainedIn
//    @XmlElement
//    @IndexedEmbedded(depth = 3)
//    @JoinTable(serviceName = "registry_user",
//            joinColumns = {
//                @JoinColumn(serviceName = "registry_id", referencedColumnName = "id")},
//            inverseJoinColumns = {
//                @JoinColumn(serviceName = "user_id", referencedColumnName = "id")})
//    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "registry.users")
//    private Set<UserEntity> users = new HashSet<>();
//
//    //For OneToOne relation
//    @PrePersist
//    @Override
//    protected void onCreate() {
//        super.setUpdatedDate(new Date());
//        super.setId(UUID.randomUUID().toString());
//        if (detail != null) {
//            detail.setId(super.getId());
//            detail.setUpdatedDate(super.getUpdatedDate());
//            detail.setRegistry(this);
//        }
//    }

}
