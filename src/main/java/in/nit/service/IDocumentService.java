package in.nit.service;

import java.util.List;

import in.nit.model.Document;

public interface IDocumentService {
    Integer saveDocument(Document doc);
    List<Object[]> getAllDocuments();
    Document getOneDocument(Integer id);

}
