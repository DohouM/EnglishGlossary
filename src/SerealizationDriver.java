import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerealizationDriver {
	Word hello = new Word("hello", "bonjour",1);
	
	FileOutputStream fos = new FileOutputStream("glossary.serial");
	
    // création d'un "flux objet" avec le flux fichier
	
    ObjectOutputStream oos= new ObjectOutputStream(fos);
    
    
    try {
        // sérialisation : écriture de l'objet dans le flux de sortie
        oos.writeObject(hello); 
        // on vide le tampon
        oos.flush();
        System.out.println(hello + " a ete serialise");
    } finally {
        //fermeture des flux
        try {
            oos.close();
        } finally {
            fos.close();
        }
    }
}



