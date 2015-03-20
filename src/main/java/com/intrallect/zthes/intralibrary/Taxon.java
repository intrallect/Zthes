package com.intrallect.zthes.intralibrary;

import com.intrallect.zthes.model.Relation;
import com.intrallect.zthes.model.Term;

public class Taxon {

	private Taxon parent;
	private String name;
	private String refId;

	public Taxon(final String refId, final String name) {
		this(refId, name, null);
	}

	public Taxon(final String refId, final String name, final Taxon parent) {
		this.refId = refId;
		this.name = name;
		this.parent = parent;
	}

	public Taxon getParent() {
		return parent;
	}

	public void setParent(final Taxon parent) {
		this.parent = parent;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(final String refId) {
		this.refId = refId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return refId + ": " + name;
	}

	public Term toTerm() {
		return toTerm(false);
	}

	public Term toTerm(final boolean shallow) {

		final Term term = new Term(getRefId(), getName());

		if (!shallow) {
			final Taxon parent = getParent();
			if (parent != null) {
				term.getRelations().add(new Relation(parent.toTerm(true)));
			}
		}
		return term;
	}
}
