public class nombreSecret
{
    public static void main(String ARGS[]) throws java.io.IOException
    {
        //- - Création des variables - -//
        int SecretNB, i, Propo;
        String Saisie;
        boolean Win;

        //- - Génération du nombre aléatoire - -//
        SecretNB = (int)(Math.random()*100+1);

        //- - Afficher l'introduction au jeu et les règles - -//
        System.out.println("Bienvenue, un nombre aléatoire a été généré entre 1 et 100 \nVous avez 10 essais pour le trouver ! \nA Pour chaque tentative, il vous sera si vous êtes 'Trop haut', 'Trop bas' ou si vous avez trouvé la bonne réponse.\n\n");

        //- - Définir les valeurs de départ de la boucle en-dessous - -//
        i = 1;
        Win = false;

        //- - Boucle Tant que Finish est faux et que i est inféreur à 10 - -//
        while (!Win && (i <= 10))
        {
            //- - Saisie d'une proposition - -//
            System.out.println("Tentative n°" + i + ", Veuillez faire une proposition entre 1 et 100"); //Message indiquant le nombre de tentative et l'invitant à faire une proposition
            System.out.print("Proposition : ");
            Saisie = Lit();

            //Tant que le joueur saisie une valeur null ou que la valeur n'est pas un entier ou que cet entier n'est pas entre 1 et 100, on lui fait ressaisir sa proposition
            while ((Saisie == null) || !IsInt(Saisie) || (Integer.parseInt(Saisie) < 1) || (Integer.parseInt(Saisie) > 100))
            {
                System.out.println("Erreur, la proposition doit être un nombre entier en 1 et 100");
                System.out.print("Proposition : ");
                Saisie = Lit();
            }
            Propo = Integer.parseInt(Saisie); //Convertion de la saisie en entier

            //- - Comparaison de la Proposition avec la réponse 
            if(Propo == SecretNB) //Si c'est la bonne réponse
            {
                System.out.println("\nFélicitation, vous avez trouvé le nombre mystère en " + i + " essais"); //Message de félicitation et affichage du nombre d'essai
                Win = true; //Mettre la variable win en vrai afin de ne plus éxecuter la boucle
            }
            else if(Propo > SecretNB) //Sinon si la réponse est trop haute
            {
                System.out.println("Trop haut\n"); //Afficher trop haut
            }
            else //sinon cela signifie que la réponse est trop basse
            {
                System.out.println("Trop bas\n"); //Afficher trop bas
            }

            i++;
        }

        if (!Win) System.out.println("Dommage, vous n'avez plus de tentative, le nombre mystère était " + SecretNB); //Si la variable Win est fausse Afficher qu'il n'y a plus de tentative est donner la réponse
    }



    //- - - - - Function - - - - -//
    //Procédure de saisie
    public static String Lit() throws java.io.IOException
    {
        String s= "";
        char c;
        while ((c=(char)System.in.read()) != '\r')
        {
            s=s+c;
        }
        c=(char)System.in.read();
        return s;
    }

    //Test d'entier
    public static Boolean IsInt(String value)
    {
        try {
			Integer.parseInt(value);
		} catch (NumberFormatException e){
			return false;
		}
 
		return true;
    }
}
