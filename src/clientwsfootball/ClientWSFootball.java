/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwsfootball;

import eu.dataaccess.footballpool.ArrayOfString;
import eu.dataaccess.footballpool.ArrayOftCountryInfo;
import eu.dataaccess.footballpool.TCountryInfo;

/**
 *
 * @author Jaime
 */
public class ClientWSFootball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Tarjetas amarillas totales: " + yellowCardsTotal());
        System.out.println("Todos los defensas de España: " + allDefenders("Spain").getString());
        System.out.println("Todos los defensas de cada país:");
        for(TCountryInfo countryInfo: countryNames(true).getTCountryInfo()){
            System.out.println("Country:"+ countryInfo.getSName());
            System.out.println("------------------------------------------");
          for(String defender: allDefenders(countryInfo.getSName()).getString()){
            System.out.println("Defensas:"+ defender);
          }
          System.out.println("------------------------------------------");
      }
    }

    private static int yellowCardsTotal() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }
    
}
