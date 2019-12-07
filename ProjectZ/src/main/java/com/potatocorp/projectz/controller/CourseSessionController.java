/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.controller;

import com.potatocorp.projectz.entity.CourseSession;
import com.potatocorp.projectz.repository.MYSQLClientDAO;

/**
 *
 * @author thoma
 */
public class CourseSessionController {
    
    public static int getNbParticipants(CourseSession cs){
        MYSQLClientDAO clDAO=new MYSQLClientDAO();
        int nbPart = clDAO.getCountByID(cs.getId());
        return nbPart;
    }
}
