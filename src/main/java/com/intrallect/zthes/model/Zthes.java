package com.intrallect.zthes.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Zthes")
public class Zthes {

	private List<Term> terms = new ArrayList<>();

	private List<Relation> relations = new ArrayList<>();

	@XmlElement(name = "term")
	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(final List<Term> terms) {
		this.terms = terms;
	}

	@XmlElement(name = "relation")
	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(final List<Relation> relations) {
		this.relations = relations;
	}
}
