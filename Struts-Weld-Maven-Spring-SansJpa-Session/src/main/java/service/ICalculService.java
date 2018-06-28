package service;

import org.springframework.beans.factory.annotation.Qualifier;

import domaine.CalculDomaine;

@Qualifier
public interface ICalculService {

	public CalculDomaine choixOperateur(CalculDomaine calculDomaine);
}
