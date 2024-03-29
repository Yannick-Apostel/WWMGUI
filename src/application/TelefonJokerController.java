package application;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import application.WWM.Frage;

public class TelefonJokerController {
	
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btn0;
	
	@FXML
	private Button btnList;
	@FXML
	private Button btnAn;
	@FXML
	private Button btnDel;
	@FXML
	private Button btnSpace;
	
	@FXML
	private TextArea txtAr;
	@FXML
	private Label lblTitle;
	
	private boolean ruftAn = false;
	
	String[] nummernliste = {"5415 4757","5113 2635","7299 2413","3416 1214","4661 1939","9974 1863","911","110","112"};
	
	public void btndown_btn1(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + "1");
		}
	}
	
	public void btndown_btn2(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + "2");
		}
	}

	public void btndown_btn3(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + "3");
		}
	}
	
	public void btndown_btn4(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + "4");
		}
	}
	
	public void btndown_btn5(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + "5");
		}
	}
	
	public void btndown_btn6(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + "6");
		}
	}
	
	public void btndown_btn7(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + "7");
		}
	}
	
	public void btndown_btn8(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + "8");
		}
	}
	
	public void btndown_btn9(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + "9");
		}
	}
	
	public void btndown_btn0(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + "0");
		}
	}
	
	public void btndown_btnSpace(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			txtAr.setText(txtAr.getText() + " ");
		}
	}
	
	public void btndown_btnDel(ActionEvent e) throws IOException {
		if (ruftAn == false) {
			if (txtAr.getText().length() > 0) {
				txtAr.setText(txtAr.getText().substring(0, txtAr.getText().length() - 1));
			}
		}
	}
	

	public void btndown_btnList(ActionEvent e) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Telefonliste.fxml"));
		Parent root1 = (Parent)fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.show();
	}
	
	public void btndown_btnAn(ActionEvent e) throws IOException {
	    if (!ruftAn) {
	        ruftAn = true;
	        String eingabe = txtAr.getText();
	        
	        AtomicInteger animationCounter = new AtomicInteger(0);
            PauseTransition pause = new PauseTransition(Duration.millis(2000));
            pause.setOnFinished(event -> {
                
                int count = animationCounter.incrementAndGet();
                if (count == 1) {
                    trythis(eingabe);
                }
            });
            Platform.runLater(() -> txtAr.setText("Klingelt . . ."));
            pause.play();
	    }
	}
	
	public void trythis(String eingabe) {
		if (eingabe.equals(nummernliste[0])) {
	    	int resultat = anrufChanceberechnung(1);
	    	if (resultat == 1) {
	    		txtAr.setText("Vater:\nSchön, dass du endlich wieder anrufst!\nIch bin mir ziemlich sicher, die richtige Antwort lautet " + getAntwort(true) + ". ");
	    	} else if (resultat == 2) {
	    		txtAr.setText("Vater:\nSchön, dass du endlich wieder anrufst!\nIch bin mir ziemlich sicher, die richtige Antwort lautet " + getAntwort(false) + ". ");
	    	} else if (resultat == 3) {
	    		txtAr.setText("Vater:\nSchön, dass du anrufst, aber die Antwort auf diese Frage kenne ich leider auch nicht.\nTut mir leid. ");
	    	}
	    } else if (eingabe.equals(nummernliste[1])) {
	    	int resultat = anrufChanceberechnung(1);
	    	if (resultat == 1) {
	    		txtAr.setText("Mutter:\nSchön, dass du dich mal wieder bei mir meldest!\nIch glaube, die richtige Antwort ist " + getAntwort(true) + ". ");
	    	} else if (resultat == 2) {
	    		txtAr.setText("Mutter:\nSchön, dass du dich mal wieder bei mir meldest!\nIch glaube, die richtige Antwort ist " + getAntwort(false)+ ". ");
	    	} else if (resultat == 3) {
	    		txtAr.setText("Mutter:\nSchön, dass du dich mal wieder bei mir meldest!, aber hier kann ich dir nicht weiterhelfen.\nSorry :( ");
	    	}
	    } else if (eingabe.equals(nummernliste[2])) {
	    	int resultat = anrufChanceberechnung(2);
	    	if (resultat == 1) {
	    		txtAr.setText("Bester Freund:\nMoinsen, was geht? Oh, eine Quiz-Show?\nLocker ist die Antwort " + getAntwort(true) + ". ");
	    	} else if (resultat == 2) {
	    		txtAr.setText("Bester Freund:\nMoinsen, was geht? Oh, eine Quiz-Show?\nLocker ist die Antwort " + getAntwort(false) + ". ");
	    	} else if (resultat == 3) {
	    		txtAr.setText("Bester Freund:\nSorry, hab gerade keine Zeit.\nVielleicht nächstes mal. ");
	    	}
	    } else if (eingabe.equals(nummernliste[3])) {
	    	int resultat = anrufChanceberechnung(3);
	    	if (resultat == 1) {
	    		txtAr.setText("Mitschüler:\nWer ist da? Oh, achso.\nIch glaube " + getAntwort(true) + " ist die richtige Antwort. ");
	    	} else if (resultat == 2) {
	    		txtAr.setText("Mitschüler:\nWer ist da? Oh, achso.\nIch glaube " + getAntwort(false) + " ist die richtige Antwort. ");
	    	} else if (resultat == 3) {
	    		txtAr.setText("Mitschüler:\nWer ist da? Oh, ähm.\nKeine Ahnung man. ");
	    	}
	    } else if (eingabe.equals(nummernliste[4])) {
	    	int resultat = anrufChanceberechnung(3);
	    	if (resultat == 1) {
	    		txtAr.setText("Nachbar:\nOh, guten Abend, klar helfe ich dir.\nIch würde auf Antwort " + getAntwort(true) + " tippen. ");
	    	} else if (resultat == 2) {
	    		txtAr.setText("Nachbar:\nOh, guten Abend, klar helfe ich dir.\nIch würde auf Antwort " + getAntwort(false) + " tippen. ");
	    	} else if (resultat == 3) {
	    		txtAr.setText("Nachbar:\nOh, guten Abend, ich würde ja gerne helfen,\naber leider ist es gerade ein sehr ungünstiger Zeitpunkt. ");
	    	}
	    	
	    } else if (eingabe.equals(nummernliste[5])) {
	    	int resultat = anrufChanceberechnung(4);
	    	if (resultat == 1) {
	    		txtAr.setText("Pablo:\nAmigo, es war die richtige Entscheidung, mich anzurufen.\nDie Antwort die du suchst, lautet " + getAntwort(true) + ". ");
	    	} else if (resultat == 2) {
	    		txtAr.setText("Pablo:\nAmigo, es war die richtige Entscheidung, mich anzurufen.\nDie Antwort die du suchst, lautet " + getAntwort(true) + ". ");
	    	} else if (resultat == 3) {
	    		txtAr.setText("Pablo:\nLo siento, hombre.\nIch kann dir hier nicht helfen. ");
	    	}
	    } else if (eingabe.equals(nummernliste[6]) || eingabe.equals(nummernliste[7]) || eingabe.equals(nummernliste[8])) {
	    	int resultat = anrufChanceberechnung(5);
	    	if (resultat == 1) {
	    		txtAr.setText("Notrufdienst:\nSie sollten doch wissen, dass man den Notruf nicht wegen einer Quizshow rufen kann.\nNagut, die Antwort lautet " + getAntwort(true) + ". ");
	    	}
	    } else {
	    	ruftAn = false;
	    	txtAr.setText("");
	    }
	}
	
	public char getAntwort(boolean richtig) {
		if (richtig) {
			for (int i = 0 ; i<4 ; i++) {
				if (((Frage) Main.getAktuelleFrage()).getAntwortenListe().get(i).getIstRichtig()) {
					switch (i) {
					case 0: return 'A';
					case 1: return 'B';
					case 2: return 'C';
					case 3: return 'D';
					}
				}
			}
		} else {
			while (true) {
				int rng = (int)(Math.random() * ((4 - 1) + 1) + 1);
				if (((Frage) Main.getAktuelleFrage()).getAntwortenListe().get(rng-1).getIstRichtig() == false) {
					switch (rng) {
					case 1: return 'A';
					case 2: return 'B';
					case 3: return 'C';
					case 4: return 'D';
					}
				}
			}
		}
		return 'x';
	}
	
	public int anrufChanceberechnung(int chance) {
		int rng = (int)(Math.random() * ((100 - 1) + 1) + 1);
		switch (chance) {
		case 1:
			if (rng > 75) {
				if (rng > 90) {
					return 3;
				} else {
					return 2;
				}
			} else {
				return 1;
			}
		case 2:
			if (rng > 80) {
				if (rng > 95) {
					return 3;
				} else {
					return 2;
				}
			} else {
				return 1;
			}
			
		case 3:
			if (rng > 70) {
				if (rng > 80) {
					return 3;
				} else {
					return 2;
				}
			} else {
				return 1;
			}
			
		case 4:
			if (rng > 85) {
				if (rng > 99) {
					return 3;
				} else {
					return 2;
				}
			} else {
				return 1;
			}
			
		case 5:
			return 1;
		
		default: return 0;
		}
	}
}