import java.util.*;

class Cards {
	//define 4 attributes for each card
  private int color;
  private int shape;
	private int number;
	private int shading;
	//------------------------------------------------------------
	//set each attribute to zero
  Cards() {
    color = 0;
    shape = 0;
    number = 0;
    shading = 0;
  }
	//------------------------------------------------------------
	//
  Cards(int col, int shap, int numb, int shad) {
    setData(col, shap, numb, shad);
  }
	//------------------------------------------------------------
	//
  void setData(int col, int shap, int numb, int shad) {
    color = col;
    shape = shap;
    number = numb;
    shading = shad;
  }
	//-----------------------------------------------------------
	int getIntColor() {
		return color;
	}
	//------------------------------------------------------------
	int getIntShape() {
		return shape;
	}
	//------------------------------------------------------------
	int getIntNumber() {
		return number;
	}
	//------------------------------------------------------------
	int getIntShading() {
		return shading;
	}
	//------------------------------------------------------------
	//Get a string value from each integer value of each atrribute
  String getColor() {
    switch (color) {
    case 0:
      return "Blue";
    case 1:
      return "Red";
    default:
      return "Green";
    }
  }
	//-------------------------------------------------------------
	//Get a string value from each integer value of each atrribute
  String getShape() {
    switch (shape) {
    case 0:
      return "Diamond";
    case 1:
      return "Oval";
    default:
      return "Squigle";
    }
  }
	//-------------------------------------------------------------
	//Get a string value from each integer value of each atrribute
	String getNumber() {
		switch (number) {
		case 0:
			return "1";
		case 1:
			return "2";
		default:
			return "3";
		}
	}
	//--------------------------------------------------------------
	//Get a string value from each integer value of each atrribute
	String getShading() {
		switch (shading) {
		case 0:
			return "Empty";
		case 1:
			return "Striped";
		default:
			return "Solid";
		}
	}
	//-------------------------------------------------------------
	//Display deck of cards
  void displayCards() {
    System.out.print(getNumber() + ", " + getColor() + ", " + getShape() + ", " + getShading());
    return;
  }
}