package com.intrallect.zthes.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "relation")
public class Relation {

	private RelationType relationType = RelationType.BT;
	private String termId;
	private String termName;

	public Relation() { }

	public Relation(final Term term) {
		this(term.getTermId(), term.getTermName());
	}

	public Relation(final String termId, final String termName) {
		this.termId = termId;
		this.termName = termName;
	}

	public Relation(final RelationType relationType, final String termName) {
		this.relationType = relationType;
		this.termName = termName;
	}

	@XmlElement
	public RelationType getRelationType() {
		return relationType;
	}

	public void setRelationType(final RelationType relationType) {
		this.relationType = relationType;
	}

	@XmlElement
	public String getTermId() {
		return termId;
	}

	public void setTermId(final String termId) {
		this.termId = termId;
	}

	@XmlElement
	public String getTermName() {
		return termName;
	}

	public void setTermName(final String termName) {
		this.termName = termName;
	}
}
