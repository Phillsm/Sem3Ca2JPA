/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Person;
import model.RoleSchool;

/**
 *
 * @author Phill
 */
public interface JSONFacade {
    
    String getPersonsAsJSON();
    String GetPersonAsJson(Integer id);
    Person addPersonFromGson(String json);
    RoleSchool addRoleFromGson(String json, Integer id);
    Person delete(Integer id);
    
}
