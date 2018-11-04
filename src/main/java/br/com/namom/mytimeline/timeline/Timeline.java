package br.com.namom.mytimeline.timeline;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.namom.mytimeline.generic.entity.GenericAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "timeline")
@EqualsAndHashCode(callSuper = false)
public class Timeline extends GenericAuditEntity<Long> implements Serializable {

	private static final long serialVersionUID = -5658713492573724579L;
	private String name;

}
