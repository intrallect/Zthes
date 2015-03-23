# Zthes
Zthes (http://zthes.z3950.org/) for Java using JAXB

# Usage

```java
// A) build your Taxonomy:
final Taxon taxon = new Taxon("refid.1", "parent");
taxon.setDescription("Some description");
final Taxon taxon2 = new Taxon("refid.1.1", "child");
taxon2.addUsefor("Usefor test");
taxon2.setParent(taxon);

// or B) build Zthes Terms directly:
final Term term = new Term("termId", "termName");
final Term term2 = new Term("termId.2", "termName2");
term2.getRelations().add(new Relation(term));

// Build a Zthes element ..
final ZthesTool tool = new ZthesTool();
// .. from taxons
final Zthes zthes = tool.taxonsToZthes(taxon, taxon2);
// .. or from terms
final Zthes zthes2 = tool.termsToZthes(term, term2);

// Get a jaxb marshaller, and use it as per usual.. :
final Marshaller marshaller = tool.getMarshaller();
marshaller.marshal(zthes, new File("/some/file.xml")); // send to a file
marshaller.marshal(zthes2, System.out); // send to an output stream
```

