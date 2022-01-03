import java.util.Vector;

public class Principale {

	static Vector<Integer>Solution=new Vector<Integer>();
	static int count = 0;
	static boolean firstsolution = false;
	static int NbNoeuds = 0;
	static int NbBacktrack=0;
	static int NbEchec = 0;
	public static void main(String[] args) {
		solveAndShowFirstSolution(10,0);
		System.out.println(count);

		System.out.println("Nombre d'echec: "+NbEchec);
		System.out.println("Nombre de backtrack: "+NbBacktrack);
		System.out.println("Nombre de noeuds: "+NbNoeuds);
	}

	public static Vector<Integer> position(int n, int col){
		Vector<Integer>ListePossible = new Vector<Integer>();
		for (int i=0; i<n;i++){
			boolean b = true;
			if (!Solution.contains(i)){
				for (int j=0;j<Solution.size();j++) {
					if (Math.abs(Solution.get(j)-i)== Math.abs(j-col)) {
						b=false ;
						NbEchec++;
						break;
					}
				}
				if (b){
					ListePossible.add(i);
				}
			}
		}
		return ListePossible;
	}
	
	public static int solveFirstSolution (int n,int col){
		if (Solution.size()==n){
			count++;
			if(!firstsolution) {
				showSolution(Solution);
				firstsolution = true;
			}
		}else{
			Vector<Integer>Valeurs=position(n,col);
			for (int i=0;i<Valeurs.size();i++){
				Solution.add(Valeurs.get(i));
				NbNoeuds++;
				solve(n,col+1);
				NbBacktrack++;
				Solution.removeElementAt(Solution.size()-1);
			}
		}
		return count;
	}
	public static void solveAllSolutions (int n,int col){
		if (Solution.size()==n){
			showSolution(Solution);
		}else{
			Vector<Integer>Valeurs=position(n,col);
			for (int i=0;i<Valeurs.size();i++){
				Solution.add(Valeurs.get(i));
				NbNoeuds++;
				solve(n,col+1);
				if (Solution.size()==n) break;
				NbBacktrack++;
				Solution.removeElementAt(Solution.size()-1);
			}
		}
	}
	public static void showSolution(Vector<Integer> Sol) {
		for(int i=0;i<Sol.size();i++) {
			for(int j=0;j<Sol.size();j++){
				int a = Sol.indexOf(i);
				if(j!=a) System.out.print("*");
				else System.out.print("Q");
			}
			System.out.println();
		}
	}
}

