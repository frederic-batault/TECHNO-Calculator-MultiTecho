package service;

import javax.enterprise.context.SessionScoped;
import domaine.CalculDomaine;

@SessionScoped
public interface ICalculService {

	public CalculDomaine choixOperateur(CalculDomaine calculDomaine);
}
