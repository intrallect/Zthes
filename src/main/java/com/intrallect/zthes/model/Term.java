package com.intrallect.zthes.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "term")
public class Term {

	private String termId;
	private String termName;
	private String termType = "PT";
	private String termNote;
	private List<Relation> relations = new ArrayList<>();

	public Term() { }

	public Term(final String termId, final String termName) {
		this.termId = termId;
		this.termName = termName;
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

	@XmlElement
	public String getTermType() {
		return termType;
	}

	public void setTermType(final String termType) {
		this.termType = termType;
	}

	@XmlElement
	public String getTermNote() {
		return termNote;
	}

	public void setTermNote(final String termNote) {
		this.termNote = termNote;
	}

	@XmlElement(name = "relation")
	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(final List<Relation> relations) {
		this.relations = relations;
	}
}
