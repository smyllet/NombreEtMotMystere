public class motSecret
{
    public static void main(String ARGS[]) throws java.io.IOException
    {
        //- - - Création variable - - -//
        Boolean SaisieOk, Finish;
        String SecretWord, Saisie, Car1, Car2, TruePosition;
        int EssaiTotal, LongSecret, i, j, TruePositionNB;


        //- - - Saisie du mot secret - - -//
        SaisieOk = false; //La Saisie n'est pas valide pour le moment

        clearScreen(); //Effacer l'ecran

        System.out.println("Bonjour joueur 1"); //Dire bonjour

        //- Faire saisir à l'utilisateur le mot secret qu'il souhaite jusqu'à que la Saisie sois validé-//
        do
        {
            //Saisie
            System.out.println("Veuillez saisir un mot d'une longueur supérieur à 3 caratères");
            System.out.print("Mot secret : ");
            SecretWord = Lit();

            //Tant que le mot Saisie à moins de 3 caractère ou qu'il contient un espace, refaire la Saisie
            while((SecretWord.length() < 3) || (SecretWord.indexOf(" ") != -1))
            {
                System.out.println("Erreur, Veuillez saisir un mot d'une longueur supérieur à 3 caratères");
                System.out.print("Mot secret : ");
                SecretWord = Lit();
            }

            //Afficher le mot secret et demander confirmation
            System.out.println("Le mot secret est " + SecretWord + ", Confirmez vous? (Oui/Non)");
            Saisie = Lit();
            //Tant qu'on ne dit pas oui ou non, ressaisir
            while(!Saisie.equals("oui") && !Saisie.equals("non"))
            {
                System.out.println("Erreur de Saisie, Le mot secret est " + SecretWord + ", Confirmez vous? (Oui/Non)");
                Saisie = Lit();
            }

            if(Saisie.equals("oui")) SaisieOk = true; //Si l'utilisateur confirme alors on defini la variable SaisieOk sur vrai afin de ne pas/plus repeter la boucle
        }while(!SaisieOk);

        LongSecret = SecretWord.length(); //Enregistrer la longueur du mot
        EssaiTotal = LongSecret-2; //Enregister le nombre d'essai total


        //- - - Donner les instructions au joueur 2 - - -//
        clearScreen(); //Effacer l'ecran pour que le joueur 2 ne voit pas la réponse (ça serait dommage quand même)

        System.out.println("Bonjour joueur 2, vous avez " + EssaiTotal + " essais pour trouver le mot d'une longueur de " + LongSecret + " caratères choisi par le joueur 1\n"); //Afficher le nombre d'essai total et la longueur du mot à trouver

        
        //- - - Essais du joueur 2 - - -//
        i=1; //Définir i à 1 ce qui correspond à son premiere essai
        Finish = false; //Finish sert à sortir de la boucle si l'utilisateur trouve la réponse ou qu'il demande la solution

        //- Tant que i est inférieur ou égal au nombre d'essai et que l'utilisateur n'a pas fini
        while((i<= EssaiTotal) && !Finish)
        {
            //Saisie de l'essai
            System.out.println("Essaie n°" + i + ", Veuillez faire une proposition de mot d'une longueur de " + LongSecret + " caratères");
            System.out.print("Proposition : ");
            Saisie = Lit();

            //- Tant que la longueur de la Saisie n'est pas égal à la longueur de la solution et que la Saisie n'est pas "sol", refaire la Saisie
            while((Saisie.length() != LongSecret) && !Saisie.equals("sol"))
            {
                System.out.println("Erreur, Veuillez faire une proposition de mot d'une longueur de " + LongSecret + " caratères");
                System.out.print("Proposition : ");
                Saisie = Lit();
            }


            if(Saisie.equals("sol")) //Si la Saisie est "sol"
            {
                System.out.println("Le mot secret etait " + SecretWord); //Afficher la réponse
                Finish = true; //Definir Finish sur vrai afin de quitter la boucle des essais
            }
            else if(Saisie.equals(SecretWord)) //Si c'est la bonne réponse
            {
                System.out.println("Félicitation le mot etait bien " + Saisie + ", vous l'avez trouvé en " + i + " essais"); //Afficher la réponse et le nombre d'essai 
                Finish = true; //Definir Finish sur vrai afin de quitter la boucle des essais
            }
            else //sinon
            {
                TruePosition = ""; //variable contenant les lettres bien placés
                TruePositionNB = 0; //Nombre de lettre bien placé

                //- Boucle pour tester les caractères un par un -//
                for(j = 0; j < Saisie.length(); j++)
                {
                    //Extraire le caratère correspondant à l'emplacement j
                    Car1 = Saisie.substring(j, j+1);
                    Car2 = SecretWord.substring(j, j+1);

                    if (Car1.equals(Car2)) //Si c'est les même caractère
                    {
                        TruePosition = TruePosition + Car1 + " "; //Ajouter le caratère à la variable TruePosition
                        TruePositionNB++; //Et ajouter 1 au nombre de lettre bien placé
                    }
                    else TruePosition = TruePosition + "_ "; //Sinon ajouter un blanc à la variable TruePosition pour signifié que la lettre n'est pas bonne
                }

                System.out.println("Vous avez " + TruePositionNB + " lettres en communes et bien placés, les voici : " + TruePosition + "\n"); //Afficher le nombre de lettre bien placé et leurs emplacements
            }
            
            i++; //Ajouter 1 à i qui correspond au nombre d'essaie en cours
        }

        if (!Finish) System.out.println("Dommage, vous n'avez plus de tentative, le mot mystère etait " + SecretWord); //Si la variable Finish est fausse afficher qu'il n'y a plus de tentative et donner la réponse

        //Exit
        System.exit(0);
    }



    //- - - - - Function - - - - -//
    //Procédure de Saisie
    public static String Lit() throws java.io.IOException
    {
        String s= "";
        char c;
        while ((c=(char)System.in.read()) != '\r')
        {
            s=s+c;
        }
        c=(char)System.in.read();
        return s.toLowerCase();
    }

    public static void clearScreen() {  
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        } 
    }
}
