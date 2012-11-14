import java.io.*;
import java.util.*;

public class HorrorShow {
	private int n;
	
	public HorrorShow(int n) {
		this.n = n;
	}
	
	public boolean equal(Object o) {
		return n == ((HorrorShow)o).n;
	}
}
