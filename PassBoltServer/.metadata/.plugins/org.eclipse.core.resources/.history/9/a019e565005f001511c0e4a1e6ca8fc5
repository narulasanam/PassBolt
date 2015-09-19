package com.passbolt.server;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * ServerLib contains helper methos for the server class.
 * The Server handles communication with the client and uses ServerLib
 * to interact with the host computer's mouse and keyboard.
 * @author Bobby
 *
 */
public class ServerLib {

	/**
	 * Move the mouse pointer by some delta values in the X and Y direction.
	 * @param dX amount to move in the X (left/right) direction
	 * @param dY amount to move in the Y (up/down) direction
	 * @throws AWTException
	 */
	public static void moveMouseBy ( int dX, int dY ) throws AWTException {
		// 10 steps
		int currentX, currentY, incrX, incrY, finalX, finalY;
		Robot r = new Robot();
		Point current = MouseInfo.getPointerInfo().getLocation();
		currentX = current.x;
		currentY = current.y;
		finalX = currentX;
		finalY = currentY;
		System.out.println("Current: X = " + currentX + " Y = " + currentY);
		
		for (int i = 0; i < 10; i++){ // move the mouse pointer incrementally over 10 smaller steps
			incrX = dX/10 + ((dX/10)*i);
			incrY = dY/10 + ((dY/10)*i);
			System.out.println(currentX + incrX);
			System.out.println(currentY + incrY);
			finalX = currentX + incrX; // position to move to with incremental value
			finalY = currentY + incrY; // position to move to with incremental value
			r.mouseMove(finalX, finalY);
			
		}
		
		r.mouseMove(finalX+(dX%10), finalY+(dY%10)); // account for any remainders that were lost through division
		
	}
	
	/**
	 * To emulate the keyboard, strings must be converted into their equivalent
	 * key strokes. These keystrokes are sent one at a time to emulate typing.
	 * @param s
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public static void typeString(String s) throws AWTException, InterruptedException {
		Robot r = new Robot();
		for (int j = 0; j < s.length(); j++){
		
			Integer [] i = {null, null};
			switch (s.charAt(j)) { // convert from char to key stroke
		        case 'a': i[1] = KeyEvent.VK_A; break;
		        case 'b': i[1] = KeyEvent.VK_B; break;
		        case 'c': i[1] = KeyEvent.VK_C; break;
		        case 'd': i[1] = KeyEvent.VK_D; break;
		        case 'e': i[1] = KeyEvent.VK_E; break;
		        case 'f': i[1] = KeyEvent.VK_F; break;
		        case 'g': i[1] = KeyEvent.VK_G; break;
		        case 'h': i[1] = KeyEvent.VK_H; break;
		        case 'i': i[1] = KeyEvent.VK_I; break;
		        case 'j': i[1] = KeyEvent.VK_J; break;
		        case 'k': i[1] = KeyEvent.VK_K; break;
		        case 'l': i[1] = KeyEvent.VK_L; break;
		        case 'm': i[1] = KeyEvent.VK_M; break;
		        case 'n': i[1] = KeyEvent.VK_N; break;
		        case 'o': i[1] = KeyEvent.VK_O; break;
		        case 'p': i[1] = KeyEvent.VK_P; break;
		        case 'q': i[1] = KeyEvent.VK_Q; break;
		        case 'r': i[1] = KeyEvent.VK_R; break;
		        case 's': i[1] = KeyEvent.VK_S; break;
		        case 't': i[1] = KeyEvent.VK_T; break;
		        case 'u': i[1] = KeyEvent.VK_U; break;
		        case 'v': i[1] = KeyEvent.VK_V; break;
		        case 'w': i[1] = KeyEvent.VK_W; break;
		        case 'x': i[1] = KeyEvent.VK_X; break;
		        case 'y': i[1] = KeyEvent.VK_Y; break;
		        case 'z': i[1] = KeyEvent.VK_Z; break;
		        case 'A': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_A; break;
		        case 'B': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_B; break;
		        case 'C': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_C; break;
		        case 'D': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_D; break;
		        case 'E': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_E; break;
		        case 'F': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_F; break;
		        case 'G': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_G; break;
		        case 'H': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_H; break;
		        case 'I': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_I; break;
		        case 'J': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_J; break;
		        case 'K': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_K; break;
		        case 'L': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_L; break;
		        case 'M': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_M; break;
		        case 'N': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_N; break;
		        case 'O': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_O; break;
		        case 'P': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_P; break;
		        case 'Q': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_Q; break;
		        case 'R': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_R; break;
		        case 'S': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_S; break;
		        case 'T': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_T; break;
		        case 'U': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_U; break;
		        case 'V': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_V; break;
		        case 'W': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_W; break;
		        case 'X': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_X; break;
		        case 'Y': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_Y; break;
		        case 'Z': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_Z; break;
		        case '`': i[1] = KeyEvent.VK_BACK_QUOTE; break;
		        case '0': i[1] = KeyEvent.VK_0; break;
		        case '1': i[1] = KeyEvent.VK_1; break;
		        case '2': i[1] = KeyEvent.VK_2; break;
		        case '3': i[1] = KeyEvent.VK_3; break;
		        case '4': i[1] = KeyEvent.VK_4; break;
		        case '5': i[1] = KeyEvent.VK_5; break;
		        case '6': i[1] = KeyEvent.VK_6; break;
		        case '7': i[1] = KeyEvent.VK_7; break;
		        case '8': i[1] = KeyEvent.VK_8; break;
		        case '9': i[1] = KeyEvent.VK_9; break;
		        case '-': i[1] = KeyEvent.VK_MINUS; break;
		        case '=': i[1] = KeyEvent.VK_EQUALS; break;
		        case '~': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_BACK_QUOTE; break;
		        case '!': i[1] = KeyEvent.VK_EXCLAMATION_MARK; break;
		        case '@': i[1] = KeyEvent.VK_AT; break;
		        case '#': i[1] = KeyEvent.VK_NUMBER_SIGN; break;
		        case '$': i[1] = KeyEvent.VK_DOLLAR; break;
		        case '%': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_5; break;
		        case '^': i[1] = KeyEvent.VK_CIRCUMFLEX; break;
		        case '&': i[1] = KeyEvent.VK_AMPERSAND; break;
		        case '*': i[1] = KeyEvent.VK_ASTERISK; break;
		        case '(': i[1] = KeyEvent.VK_LEFT_PARENTHESIS; break;
		        case ')': i[1] = KeyEvent.VK_RIGHT_PARENTHESIS; break;
		        case '_': i[1] = KeyEvent.VK_UNDERSCORE; break;
		        case '+': i[1] = KeyEvent.VK_PLUS; break;
		        case '\t': i[1] = KeyEvent.VK_TAB; break;
		        case '\n': i[1] = KeyEvent.VK_ENTER; break;
		        case '[': i[1] = KeyEvent.VK_OPEN_BRACKET; break;
		        case '\\': i[1] = KeyEvent.VK_BACK_SLASH; break;
		        case '{': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_OPEN_BRACKET; break;
		        case '}': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_CLOSE_BRACKET; break;
		        case '|': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_BACK_SLASH; break;
		        case ';': i[1] = KeyEvent.VK_SEMICOLON; break;
		        case ':': i[1] = KeyEvent.VK_COLON; break;
		        case '\'': i[1] = KeyEvent.VK_QUOTE; break;
		        case '"': i[1] = KeyEvent.VK_QUOTEDBL; break;
		        case ',': i[1] = KeyEvent.VK_COMMA; break;
		        case '<': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_COMMA; break;
		        case '.': i[1] = KeyEvent.VK_PERIOD; break;
		        case '>': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_PERIOD; break;
		        case '/': i[1] = KeyEvent.VK_SLASH; break;
		        case '?': i[0] = KeyEvent.VK_SHIFT; i[1] = KeyEvent.VK_SLASH; break;
		        case ' ': i[1] = KeyEvent.VK_SPACE; break;
		        default:
		            throw new IllegalArgumentException("Cannot type character ");
	        }
			
			
			Thread.sleep(100); // send a keystroke every 100 ms
			if (i[0] != null)
				r.keyPress(i[0]);
			
			r.keyPress(i[1]);
			r.keyRelease(i[1]);
			
			if (i[0] != null)
				r.keyRelease(i[0]);
		}
		
	}
	
	/**
	 * Emulate a mouse click. Handles both left and right click.
	 * @param i value for 1 for left click, value of 2 for right click.
	 * @throws AWTException
	 */
	public static void click (int i) throws AWTException {
		int button;
		
		switch (i) { // convert from button number to the proper mouse event.
		case 1: button = InputEvent.BUTTON1_MASK; break;
		case 2: button = InputEvent.BUTTON3_MASK; break;
		default: button = InputEvent.BUTTON1_MASK; break;
		}
		
		Robot r = new Robot();
		r.mousePress(button); // emulate the click.
		r.mouseRelease(button);
		
	}
	
	/**
	 * Emulate the mouse wheel scroll. 
	 * @param i How many "clicks" from the scroll wheel to emulate.
	 * @throws AWTException
	 */
	public static void scroll(int i) throws AWTException {
		Robot r = new Robot();
		r.mouseWheel(i); // scroll!
	}
	
}
