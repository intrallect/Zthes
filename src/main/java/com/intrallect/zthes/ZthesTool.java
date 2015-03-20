package com.intrallect.zthes;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.intrallect.zthes.intralibrary.Taxon;
import com.intrallect.zthes.model.Term;
import com.intrallect.zthes.model.Zthes;

public class ZthesTool {

	public static final String XTHES_XSD_URL = "http://zthes.z3950.org/schema/zthes-1.0.xsd";

	public Marshaller getMarshaller() throws JAXBException {

		final JAXBContext context = JAXBContext.newInstance(Zthes.class);
		final Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, XTHES_XSD_URL);

		return marshaller;
	}

	public Zthes termsToZthes(final Term... term) {
		return termsToZthes(Arrays.asList(term));
	}

	public Zthes termsToZthes(final Collection<Term> terms) {

		final Zthes zthes = new Zthes();
		zthes.getTerms().addAll(terms);

		return zthes;
	}

	public Zthes taxonsToZthes(final Taxon... taxon) {
		return taxonsToZthes(Arrays.asList(taxon));
	}

	public Zthes taxonsToZthes(final Collection<Taxon> taxons) {

		final Zthes zthes = new Zthes();
		final List<Term> terms = zthes.getTerms();

		for (final Taxon taxon : taxons) {
			terms.add(taxon.toTerm());
		}

		return zthes;
	}

}
