package enJava.fichiers.Controller.Enseignant.Toeic;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import enJava.fichiers.Config.ConnectionUtil;
import enJava.fichiers.Controller.Login.FXMLDocumentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Cr�erUnTOEICScreenController implements Initializable {

	// Il faut cr�er un tableau de TextField de taille 200 pour les r�ponses du TOEIC
	// Il faut le textField du nom de TOEIC
	// Si tous les champs sont remplis, qu'il y a seulement des A, B, C et D et que le nom n'existe pas d�j�, on cr�� le nouveau TOEIC
	// Il faut donc les 7 parties dans ce TOIEC, avec chacune leur lots de questions
	
	// Nom du nouveau TOEIC
	@FXML
	private TextField textNomTOEIC;
	
	// Les 200 r�ponses
	@FXML
	private TextField textQ1;
	@FXML
	private TextField textQ2;
	@FXML
	private TextField textQ3;
	@FXML
	private TextField textQ4;
	@FXML
	private TextField textQ5;
	@FXML
	private TextField textQ6;
	@FXML
	private TextField textQ7;
	@FXML
	private TextField textQ8;
	@FXML
	private TextField textQ9;
	@FXML
	private TextField textQ10;
	@FXML
	private TextField textQ11;
	@FXML
	private TextField textQ12;
	@FXML
	private TextField textQ13;
	@FXML
	private TextField textQ14;
	@FXML
	private TextField textQ15;
	@FXML
	private TextField textQ16;
	@FXML
	private TextField textQ17;
	@FXML
	private TextField textQ18;
	@FXML
	private TextField textQ19;
	@FXML
	private TextField textQ20;
	@FXML
	private TextField textQ21;
	@FXML
	private TextField textQ22;
	@FXML
	private TextField textQ23;
	@FXML
	private TextField textQ24;
	@FXML
	private TextField textQ25;
	@FXML
	private TextField textQ26;
	@FXML
	private TextField textQ27;
	@FXML
	private TextField textQ28;
	@FXML
	private TextField textQ29;
	@FXML
	private TextField textQ30;
	@FXML
	private TextField textQ31;
	@FXML
	private TextField textQ32;
	@FXML
	private TextField textQ33;
	@FXML
	private TextField textQ34;
	@FXML
	private TextField textQ35;
	@FXML
	private TextField textQ36;
	@FXML
	private TextField textQ37;
	@FXML
	private TextField textQ38;
	@FXML
	private TextField textQ39;
	@FXML
	private TextField textQ40;
	@FXML
	private TextField textQ41;
	@FXML
	private TextField textQ42;
	@FXML
	private TextField textQ43;
	@FXML
	private TextField textQ44;
	@FXML
	private TextField textQ45;
	@FXML
	private TextField textQ46;
	@FXML
	private TextField textQ47;
	@FXML
	private TextField textQ48;
	@FXML
	private TextField textQ49;
	@FXML
	private TextField textQ50;
	@FXML
	private TextField textQ51;
	@FXML
	private TextField textQ52;
	@FXML
	private TextField textQ53;
	@FXML
	private TextField textQ54;
	@FXML
	private TextField textQ55;
	@FXML
	private TextField textQ56;
	@FXML
	private TextField textQ57;
	@FXML
	private TextField textQ58;
	@FXML
	private TextField textQ59;
	@FXML
	private TextField textQ60;
	@FXML
	private TextField textQ61;
	@FXML
	private TextField textQ62;
	@FXML
	private TextField textQ63;
	@FXML
	private TextField textQ64;
	@FXML
	private TextField textQ65;
	@FXML
	private TextField textQ66;
	@FXML
	private TextField textQ67;
	@FXML
	private TextField textQ68;
	@FXML
	private TextField textQ69;
	@FXML
	private TextField textQ70;
	@FXML
	private TextField textQ71;
	@FXML
	private TextField textQ72;
	@FXML
	private TextField textQ73;
	@FXML
	private TextField textQ74;
	@FXML
	private TextField textQ75;
	@FXML
	private TextField textQ76;
	@FXML
	private TextField textQ77;
	@FXML
	private TextField textQ78;
	@FXML
	private TextField textQ79;
	@FXML
	private TextField textQ80;
	@FXML
	private TextField textQ81;
	@FXML
	private TextField textQ82;
	@FXML
	private TextField textQ83;
	@FXML
	private TextField textQ84;
	@FXML
	private TextField textQ85;
	@FXML
	private TextField textQ86;
	@FXML
	private TextField textQ87;
	@FXML
	private TextField textQ88;
	@FXML
	private TextField textQ89;
	@FXML
	private TextField textQ90;
	@FXML
	private TextField textQ91;
	@FXML
	private TextField textQ92;
	@FXML
	private TextField textQ93;
	@FXML
	private TextField textQ94;
	@FXML
	private TextField textQ95;
	@FXML
	private TextField textQ96;
	@FXML
	private TextField textQ97;
	@FXML
	private TextField textQ98;
	@FXML
	private TextField textQ99;
	@FXML
	private TextField textQ100;
	@FXML
	private TextField textQ101;
	@FXML
	private TextField textQ102;
	@FXML
	private TextField textQ103;
	@FXML
	private TextField textQ104;
	@FXML
	private TextField textQ105;
	@FXML
	private TextField textQ106;
	@FXML
	private TextField textQ107;
	@FXML
	private TextField textQ108;
	@FXML
	private TextField textQ109;
	@FXML
	private TextField textQ110;
	@FXML
	private TextField textQ111;
	@FXML
	private TextField textQ112;
	@FXML
	private TextField textQ113;
	@FXML
	private TextField textQ114;
	@FXML
	private TextField textQ115;
	@FXML
	private TextField textQ116;
	@FXML
	private TextField textQ117;
	@FXML
	private TextField textQ118;
	@FXML
	private TextField textQ119;
	@FXML
	private TextField textQ120;
	@FXML
	private TextField textQ121;
	@FXML
	private TextField textQ122;
	@FXML
	private TextField textQ123;
	@FXML
	private TextField textQ124;
	@FXML
	private TextField textQ125;
	@FXML
	private TextField textQ126;
	@FXML
	private TextField textQ127;
	@FXML
	private TextField textQ128;
	@FXML
	private TextField textQ129;
	@FXML
	private TextField textQ130;
	@FXML
	private TextField textQ131;
	@FXML
	private TextField textQ132;
	@FXML
	private TextField textQ133;
	@FXML
	private TextField textQ134;
	@FXML
	private TextField textQ135;
	@FXML
	private TextField textQ136;
	@FXML
	private TextField textQ137;
	@FXML
	private TextField textQ138;
	@FXML
	private TextField textQ139;
	@FXML
	private TextField textQ140;
	@FXML
	private TextField textQ141;
	@FXML
	private TextField textQ142;
	@FXML
	private TextField textQ143;
	@FXML
	private TextField textQ144;
	@FXML
	private TextField textQ145;
	@FXML
	private TextField textQ146;
	@FXML
	private TextField textQ147;
	@FXML
	private TextField textQ148;
	@FXML
	private TextField textQ149;
	@FXML
	private TextField textQ150;
	@FXML
	private TextField textQ151;
	@FXML
	private TextField textQ152;
	@FXML
	private TextField textQ153;
	@FXML
	private TextField textQ154;
	@FXML
	private TextField textQ155;
	@FXML
	private TextField textQ156;
	@FXML
	private TextField textQ157;
	@FXML
	private TextField textQ158;
	@FXML
	private TextField textQ159;
	@FXML
	private TextField textQ160;
	@FXML
	private TextField textQ161;
	@FXML
	private TextField textQ162;
	@FXML
	private TextField textQ163;
	@FXML
	private TextField textQ164;
	@FXML
	private TextField textQ165;
	@FXML
	private TextField textQ166;
	@FXML
	private TextField textQ167;
	@FXML
	private TextField textQ168;
	@FXML
	private TextField textQ169;
	@FXML
	private TextField textQ170;
	@FXML
	private TextField textQ171;
	@FXML
	private TextField textQ172;
	@FXML
	private TextField textQ173;
	@FXML
	private TextField textQ174;
	@FXML
	private TextField textQ175;
	@FXML
	private TextField textQ176;
	@FXML
	private TextField textQ177;
	@FXML
	private TextField textQ178;
	@FXML
	private TextField textQ179;
	@FXML
	private TextField textQ180;
	@FXML
	private TextField textQ181;
	@FXML
	private TextField textQ182;
	@FXML
	private TextField textQ183;
	@FXML
	private TextField textQ184;
	@FXML
	private TextField textQ185;
	@FXML
	private TextField textQ186;
	@FXML
	private TextField textQ187;
	@FXML
	private TextField textQ188;
	@FXML
	private TextField textQ189;
	@FXML
	private TextField textQ190;
	@FXML
	private TextField textQ191;
	@FXML
	private TextField textQ192;
	@FXML
	private TextField textQ193;
	@FXML
	private TextField textQ194;
	@FXML
	private TextField textQ195;
	@FXML
	private TextField textQ196;
	@FXML
	private TextField textQ197;
	@FXML
	private TextField textQ198;
	@FXML
	private TextField textQ199;
	@FXML
	private TextField textQ200;
	
	// Permet de stocker 
	static String NomTOEIC;
	// Permet de stocker les 200 r�ponses
	static String[] R�ponses = new String[200];
	
	// Permet de stocker une erreur dans l'entr�e de texte des r�ponses
	private Boolean ErreurText;
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    // Bouton Permettant de cr�er le TOEIC � partir de ce qu'il y a d'entrer
    public void Enregistrer(ActionEvent event) {
    	ErreurText = false;
    	// On r�cup�re le nom entr� par l'utilisateur
    	NomTOEIC = textNomTOEIC.getText().toString();
    	// On r�cup�re chaque r�ponse dans le tableau, une par une parce qu'avec un tableau de TextField �a ne marchait pas
    	R�ponses[0] = textQ1.getText().toString();
    	R�ponses[1] = textQ2.getText().toString();
    	R�ponses[2] = textQ3.getText().toString();
    	R�ponses[3] = textQ4.getText().toString();
    	R�ponses[4] = textQ5.getText().toString();
    	R�ponses[5] = textQ6.getText().toString();
    	R�ponses[6] = textQ7.getText().toString();
    	R�ponses[7] = textQ8.getText().toString();
    	R�ponses[8] = textQ9.getText().toString();
    	R�ponses[9] = textQ10.getText().toString();
    	R�ponses[10] = textQ11.getText().toString();
    	R�ponses[11] = textQ12.getText().toString();
    	R�ponses[12] = textQ13.getText().toString();
    	R�ponses[13] = textQ14.getText().toString();
    	R�ponses[14] = textQ15.getText().toString();
    	R�ponses[15] = textQ16.getText().toString();
    	R�ponses[16] = textQ17.getText().toString();
    	R�ponses[17] = textQ18.getText().toString();
    	R�ponses[18] = textQ19.getText().toString();
    	R�ponses[19] = textQ20.getText().toString();
    	R�ponses[20] = textQ21.getText().toString();
    	R�ponses[21] = textQ22.getText().toString();
    	R�ponses[22] = textQ23.getText().toString();
    	R�ponses[23] = textQ24.getText().toString();
    	R�ponses[24] = textQ25.getText().toString();
    	R�ponses[25] = textQ26.getText().toString();
    	R�ponses[26] = textQ27.getText().toString();
    	R�ponses[27] = textQ28.getText().toString();
    	R�ponses[28] = textQ29.getText().toString();
    	R�ponses[29] = textQ30.getText().toString();
    	R�ponses[30] = textQ31.getText().toString();
    	R�ponses[31] = textQ32.getText().toString();
    	R�ponses[32] = textQ33.getText().toString();
    	R�ponses[33] = textQ34.getText().toString();
    	R�ponses[34] = textQ35.getText().toString();
    	R�ponses[35] = textQ36.getText().toString();
    	R�ponses[36] = textQ37.getText().toString();
    	R�ponses[37] = textQ38.getText().toString();
    	R�ponses[38] = textQ39.getText().toString();
    	R�ponses[39] = textQ40.getText().toString();
    	R�ponses[40] = textQ41.getText().toString();
    	R�ponses[41] = textQ42.getText().toString();
    	R�ponses[42] = textQ43.getText().toString();
    	R�ponses[43] = textQ44.getText().toString();
    	R�ponses[44] = textQ45.getText().toString();
    	R�ponses[45] = textQ46.getText().toString();
    	R�ponses[46] = textQ47.getText().toString();
    	R�ponses[47] = textQ48.getText().toString();
    	R�ponses[48] = textQ49.getText().toString();
    	R�ponses[49] = textQ50.getText().toString();
    	R�ponses[50] = textQ51.getText().toString();
    	R�ponses[51] = textQ52.getText().toString();
    	R�ponses[52] = textQ53.getText().toString();
    	R�ponses[53] = textQ54.getText().toString();
    	R�ponses[54] = textQ55.getText().toString();
    	R�ponses[55] = textQ56.getText().toString();
    	R�ponses[56] = textQ57.getText().toString();
    	R�ponses[57] = textQ58.getText().toString();
    	R�ponses[58] = textQ59.getText().toString();
    	R�ponses[59] = textQ60.getText().toString();
    	R�ponses[60] = textQ61.getText().toString();
    	R�ponses[61] = textQ62.getText().toString();
    	R�ponses[62] = textQ63.getText().toString();
    	R�ponses[63] = textQ64.getText().toString();
    	R�ponses[64] = textQ65.getText().toString();
    	R�ponses[65] = textQ66.getText().toString();
    	R�ponses[66] = textQ67.getText().toString();
    	R�ponses[67] = textQ68.getText().toString();
    	R�ponses[68] = textQ69.getText().toString();
    	R�ponses[69] = textQ70.getText().toString();
    	R�ponses[70] = textQ71.getText().toString();
    	R�ponses[71] = textQ72.getText().toString();
    	R�ponses[72] = textQ73.getText().toString();
    	R�ponses[73] = textQ74.getText().toString();
    	R�ponses[74] = textQ75.getText().toString();
    	R�ponses[75] = textQ76.getText().toString();
    	R�ponses[76] = textQ77.getText().toString();
    	R�ponses[77] = textQ78.getText().toString();
    	R�ponses[78] = textQ79.getText().toString();
    	R�ponses[79] = textQ80.getText().toString();
    	R�ponses[80] = textQ81.getText().toString();
    	R�ponses[81] = textQ82.getText().toString();
    	R�ponses[82] = textQ83.getText().toString();
    	R�ponses[83] = textQ84.getText().toString();
    	R�ponses[84] = textQ85.getText().toString();
    	R�ponses[85] = textQ86.getText().toString();
    	R�ponses[86] = textQ87.getText().toString();
    	R�ponses[87] = textQ88.getText().toString();
    	R�ponses[88] = textQ89.getText().toString();
    	R�ponses[89] = textQ90.getText().toString();
    	R�ponses[90] = textQ91.getText().toString();
    	R�ponses[91] = textQ92.getText().toString();
    	R�ponses[92] = textQ93.getText().toString();
    	R�ponses[93] = textQ94.getText().toString();
    	R�ponses[94] = textQ95.getText().toString();
    	R�ponses[95] = textQ96.getText().toString();
    	R�ponses[96] = textQ97.getText().toString();
    	R�ponses[97] = textQ98.getText().toString();
    	R�ponses[98] = textQ99.getText().toString();
    	R�ponses[99] = textQ100.getText().toString();
    	R�ponses[100] = textQ101.getText().toString();
    	R�ponses[101] = textQ102.getText().toString();
    	R�ponses[102] = textQ103.getText().toString();
    	R�ponses[103] = textQ104.getText().toString();
    	R�ponses[104] = textQ105.getText().toString();
    	R�ponses[105] = textQ106.getText().toString();
    	R�ponses[106] = textQ107.getText().toString();
    	R�ponses[107] = textQ108.getText().toString();
    	R�ponses[108] = textQ109.getText().toString();
    	R�ponses[109] = textQ110.getText().toString();
    	R�ponses[110] = textQ111.getText().toString();
    	R�ponses[111] = textQ112.getText().toString();
    	R�ponses[112] = textQ113.getText().toString();
    	R�ponses[113] = textQ114.getText().toString();
    	R�ponses[114] = textQ115.getText().toString();
    	R�ponses[115] = textQ116.getText().toString();
    	R�ponses[116] = textQ117.getText().toString();
    	R�ponses[117] = textQ118.getText().toString();
    	R�ponses[118] = textQ119.getText().toString();
    	R�ponses[119] = textQ120.getText().toString();
    	R�ponses[120] = textQ121.getText().toString();
    	R�ponses[121] = textQ122.getText().toString();
    	R�ponses[122] = textQ123.getText().toString();
    	R�ponses[123] = textQ124.getText().toString();
    	R�ponses[124] = textQ125.getText().toString();
    	R�ponses[125] = textQ126.getText().toString();
    	R�ponses[126] = textQ127.getText().toString();
    	R�ponses[127] = textQ128.getText().toString();
    	R�ponses[128] = textQ129.getText().toString();
    	R�ponses[129] = textQ130.getText().toString();
    	R�ponses[130] = textQ131.getText().toString();
    	R�ponses[131] = textQ132.getText().toString();
    	R�ponses[132] = textQ133.getText().toString();
    	R�ponses[133] = textQ134.getText().toString();
    	R�ponses[134] = textQ135.getText().toString();
    	R�ponses[135] = textQ136.getText().toString();
    	R�ponses[136] = textQ137.getText().toString();
    	R�ponses[137] = textQ138.getText().toString();
    	R�ponses[138] = textQ139.getText().toString();
    	R�ponses[139] = textQ140.getText().toString();
    	R�ponses[140] = textQ141.getText().toString();
    	R�ponses[141] = textQ142.getText().toString();
    	R�ponses[142] = textQ143.getText().toString();
    	R�ponses[143] = textQ144.getText().toString();
    	R�ponses[144] = textQ145.getText().toString();
    	R�ponses[145] = textQ146.getText().toString();
    	R�ponses[146] = textQ147.getText().toString();
    	R�ponses[147] = textQ148.getText().toString();
    	R�ponses[148] = textQ149.getText().toString();
    	R�ponses[149] = textQ150.getText().toString();
    	R�ponses[150] = textQ151.getText().toString();
    	R�ponses[151] = textQ152.getText().toString();
    	R�ponses[152] = textQ153.getText().toString();
    	R�ponses[153] = textQ154.getText().toString();
    	R�ponses[154] = textQ155.getText().toString();
    	R�ponses[155] = textQ156.getText().toString();
    	R�ponses[156] = textQ157.getText().toString();
    	R�ponses[157] = textQ158.getText().toString();
    	R�ponses[158] = textQ159.getText().toString();
    	R�ponses[159] = textQ160.getText().toString();
    	R�ponses[160] = textQ161.getText().toString();
    	R�ponses[161] = textQ162.getText().toString();
    	R�ponses[162] = textQ163.getText().toString();
    	R�ponses[163] = textQ164.getText().toString();
    	R�ponses[164] = textQ165.getText().toString();
    	R�ponses[165] = textQ166.getText().toString();
    	R�ponses[166] = textQ167.getText().toString();
    	R�ponses[167] = textQ168.getText().toString();
    	R�ponses[168] = textQ169.getText().toString();
    	R�ponses[169] = textQ170.getText().toString();
    	R�ponses[170] = textQ171.getText().toString();
    	R�ponses[171] = textQ172.getText().toString();
    	R�ponses[172] = textQ173.getText().toString();
    	R�ponses[173] = textQ174.getText().toString();
    	R�ponses[174] = textQ175.getText().toString();
    	R�ponses[175] = textQ176.getText().toString();
    	R�ponses[176] = textQ177.getText().toString();
    	R�ponses[177] = textQ178.getText().toString();
    	R�ponses[178] = textQ179.getText().toString();
    	R�ponses[179] = textQ180.getText().toString();
    	R�ponses[180] = textQ181.getText().toString();
    	R�ponses[181] = textQ182.getText().toString();
    	R�ponses[182] = textQ183.getText().toString();
    	R�ponses[183] = textQ184.getText().toString();
    	R�ponses[184] = textQ185.getText().toString();
    	R�ponses[185] = textQ186.getText().toString();
    	R�ponses[186] = textQ187.getText().toString();
    	R�ponses[187] = textQ188.getText().toString();
    	R�ponses[188] = textQ189.getText().toString();
    	R�ponses[189] = textQ190.getText().toString();
    	R�ponses[190] = textQ191.getText().toString();
    	R�ponses[191] = textQ192.getText().toString();
    	R�ponses[192] = textQ193.getText().toString();
    	R�ponses[193] = textQ194.getText().toString();
    	R�ponses[194] = textQ195.getText().toString();
    	R�ponses[195] = textQ196.getText().toString();
    	R�ponses[196] = textQ197.getText().toString();
    	R�ponses[197] = textQ198.getText().toString();
    	R�ponses[198] = textQ199.getText().toString();
    	R�ponses[199] = textQ200.getText().toString();
    	
    	// On v�rifie d'abord que le nom de TOEIC existe
    	if (!NomTOEIC.equals("")) {
    		// Cette requ�te permet de dire si le nom a d�j� �t� utilis� ou non
    		String sql1 = "SELECT COUNT(*) FROM Toeic WHERE LibelleTOEIC = ?";
    		
    		try {
    			preparedStatement = connection.prepareStatement(sql1);
                preparedStatement.setString(1, NomTOEIC);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                	if (resultSet.getInt(1) == 0) {
                    	// On v�rifie ici que les 200 r�ponses sont valides
            			for (int i = 0 ; i<R�ponses.length ; i++) {
            				if ((!R�ponses[i].equals("A") && !R�ponses[i].equals("B") && !R�ponses[i].equals("C") && !R�ponses[i].equals("D")) || ((R�ponses[i].equals("")))) {
                				ErreurText = true;    				
            				}
            			}
            			if (!ErreurText) {
            				// On r�cup�re l'idUtilisateur du prof
            				String sql2 = "SELECT idUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
            				preparedStatement = connection.prepareStatement(sql2);
            	            preparedStatement.setString(1, FXMLDocumentController.mail());
            	            preparedStatement.setString(2, FXMLDocumentController.mdp());
            	            resultSet = preparedStatement.executeQuery();
            	            if (resultSet.next()) {
            	            	int idU = resultSet.getInt(1);
            	            	// On fait d'abord une requ�te permettant d'avoir le num TOEIC
            	            	int numTOEIC = 1;
            	            	Boolean rep = false;
            	            	// On va chercher le premier NumTOEIC disponible en partant de 0
            	            	while (!rep) {
            	            		String test ="SELECT COUNT(*) FROM Toeic WHERE NumTOEIC = ?";
            	            		preparedStatement = connection.prepareStatement(test);
            	            		preparedStatement.setInt(1, numTOEIC);
            	            		resultSet = preparedStatement.executeQuery();
            	            		if(resultSet.next()) {
            	            			int count = resultSet.getInt(1);
            	            			if(count == 0) {
            	            				rep = true;
            	            			}
            	            			else {
            	            				numTOEIC++;
            	            			}
            	            		}
            	            	}
            	            	// On a tout, i est un numToeic valide, on peut le cr�er dans la BDD
	            				String insert = "INSERT into Toeic (NumTOEIC,LibelleTOEIC,Enseignant) VALUES (?,?,?)";
                				preparedStatement = connection.prepareStatement(insert);
                        		preparedStatement.setInt(1, numTOEIC);
                                preparedStatement.setString(2, NomTOEIC);
                                preparedStatement.setInt(3,idU);
                                preparedStatement.executeUpdate();
                                insert = "INSERT into Toeic (NumTOEIC,LibelleTOEIC,Enseignant) VALUES (?,?,?)";
                                
            	            	// On doit maintenant cr�er les 7 parties
            	            	for (int j=1 ; j<=7 ; j++) {
            	            		String part = "INSERT into Partie (NumPart,LibellePart,NumTOEIC) VALUES (?,?,?)";
            	            		preparedStatement = connection.prepareStatement(part);
                            		preparedStatement.setInt(1, j);
                            		String libPart = "Part " + Integer.toString(j);
                                    preparedStatement.setString(2, libPart);
                                    preparedStatement.setInt(3,numTOEIC);
                                    preparedStatement.executeUpdate();
                                    part = "INSERT into Partie (NumPart,LibellePart,NumTOEIC) VALUES (?,?,?)";
            	            	}
            	            	
            	            	// On doit maintenant faire les questions, avec les bonnes corrections
            	            	
            	            	// Partie 1
            	            	
            	            	for (int k = 0 ; k<6 ; k++) {
            	            		String answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            		preparedStatement = connection.prepareStatement(answer);
                            		preparedStatement.setInt(1, 1);
                                    preparedStatement.setInt(2, k+1);
                                    preparedStatement.setInt(3,numTOEIC);
                                    preparedStatement.setString(4,R�ponses[k]);
                                    preparedStatement.executeUpdate();
                                    answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            	}
            	            	
            	            	// Partie 2
            	            	
            	            	for (int k = 6 ; k<31 ; k++) {
            	            		String answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            		preparedStatement = connection.prepareStatement(answer);
                            		preparedStatement.setInt(1, 2);
                                    preparedStatement.setInt(2, k+1);
                                    preparedStatement.setInt(3,numTOEIC);
                                    preparedStatement.setString(4,R�ponses[k]);
                                    preparedStatement.executeUpdate();
                                    answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            	}
            	            	
            	            	// Partie 3
            	            	
            	            	for (int k = 31  ; k<70 ; k++) {
            	            		String answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            		preparedStatement = connection.prepareStatement(answer);
                            		preparedStatement.setInt(1, 3);
                                    preparedStatement.setInt(2, k+1);
                                    preparedStatement.setInt(3,numTOEIC);
                                    preparedStatement.setString(4,R�ponses[k]);
                                    preparedStatement.executeUpdate();
                                    answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            	}
            	            	
            	            	// Partie 4
            	            	
            	            	for (int k = 70  ; k<100 ; k++) {
            	            		String answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            		preparedStatement = connection.prepareStatement(answer);
                            		preparedStatement.setInt(1, 4);
                                    preparedStatement.setInt(2, k+1);
                                    preparedStatement.setInt(3,numTOEIC);
                                    preparedStatement.setString(4,R�ponses[k]);
                                    preparedStatement.executeUpdate();
                                    answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            	}
            	            	
            	            	// Partie 5
            	            	
            	            	for (int k = 100  ; k<130 ; k++) {
            	            		String answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            		preparedStatement = connection.prepareStatement(answer);
                            		preparedStatement.setInt(1, 5);
                                    preparedStatement.setInt(2, k+1);
                                    preparedStatement.setInt(3,numTOEIC);
                                    preparedStatement.setString(4,R�ponses[k]);
                                    preparedStatement.executeUpdate();
                                    answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            	}
            	            	
            	            	// Partie 6
            	            	
            	            	for (int k = 130  ; k<146 ; k++) {
            	            		String answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            		preparedStatement = connection.prepareStatement(answer);
                            		preparedStatement.setInt(1, 6);
                                    preparedStatement.setInt(2, k+1);
                                    preparedStatement.setInt(3,numTOEIC);
                                    preparedStatement.setString(4,R�ponses[k]);
                                    preparedStatement.executeUpdate();
                                    answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            	}
            	            	
            	            	// Partie 7
            	            	
            	            	for (int k = 146  ; k<200 ; k++) {
            	            		String answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            		preparedStatement = connection.prepareStatement(answer);
                            		preparedStatement.setInt(1, 7);
                                    preparedStatement.setInt(2, k+1);
                                    preparedStatement.setInt(3,numTOEIC);
                                    preparedStatement.setString(4,R�ponses[k]);
                                    preparedStatement.executeUpdate();
                                    answer = "INSERT into Question (NumPart,NumQuestion,NumTOEIC,CorrectionQuestion) VALUES (?,?,?,?)";
            	            	}
            	            	infoBox("Le TOEIC : "+ NomTOEIC + " a �t� enregistr� avec succ�s.", null, "Success");
            	            }
            			}
            			else {
            				infoBox("Vous devez entrer des r�ponses valides (A,B,C ou D)", null , "Erreur");
            			}
                    }
                    else {
                    	infoBox("Ce nom existe d�j�, veuillez en choisir un autre.", null, "Erreur");
                    }
                }
    		}
            catch(Exception e){
            	e.printStackTrace();
            }
    	}
    	else {
    		infoBox("Veuillez rentrer un nom de TOEIC", null, "Erreur");
    	}
    }
	
	public Cr�erUnTOEICScreenController() {
        connection = ConnectionUtil.connectdb();
    }
	
	// Bouton Home
	public void Home(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/AccueilProfScreen.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	// Bouton retour page tous les TOEIC
	public void RetourToutTOEIC(ActionEvent event) {
		try {	
			Node node = (Node)event.getSource();
	        dialogStage = (Stage) node.getScene().getWindow();
	        dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Toeic/AfficherTousLesTOEICSScreen.fxml")));
	        }
		catch(Exception e){
			e.printStackTrace();
	    }
	}	
	
    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
	
	public static String NomTOEIC() {
		return NomTOEIC;
	}
	
	public static String[] R�ponses() {
		return R�ponses;
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
