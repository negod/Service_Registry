/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.backede.service.registry.dto;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Joakim Backede ( joakim.backede@outlook.com )
 */
@Data
public class Dependencies implements Serializable {

    String url;
    String serviceName;

}
