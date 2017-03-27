package leeTs.Medium;

public class _223_Rectangle_Area {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int result = computeAreaNaive(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1);

	}
	/*
	 * Just refer to the only provided diagram to make a basic function, then use it to handle
	 * one non overlapping case, then we just have the generous solution*/
	public int computeAreaWithTrick(int A, int B, int C, int D, int E, int F, int G, int H) {
		int overlappingLeft = Math.max(A, E);
		int overlappingRight = Math.max(Math.min(C, G), overlappingLeft);
		int overlappingCeiling = Math.min(H, D);
		int overlappingFloor = Math.min(Math.max(B, F), overlappingCeiling);
		return (C - A) * (D - B) + (G - E) * (H - F) - (overlappingRight - overlappingLeft) * (overlappingCeiling - overlappingFloor);
	}
	
	public static int computeAreaNaive(int A, int B, int C, int D, int E, int F, int G, int H) {
		int horizontal1 = C - A;
		int vertical1 = D - B;
		int horizontal2 = G - E;
		int vertical2 = H - F;
		int area1 = horizontal1 * vertical1;
		int area2 = horizontal2 * vertical2;
		int horizontalLeft = 0;
		int horizontalRight = 0;
		int boundLeft = 0;
		int horizontalUpper = 0;
		int horizontalLower = 0;
		int boundLower = 0;
		int overlapHorizontal = 0;
		int overlapVertical = 0;
		if(G > C) {
			horizontalRight = C;
			horizontalLeft = E;
			boundLeft = A;
		}
		else {
			horizontalRight = G;
			horizontalLeft = A;
			boundLeft = E;
		}
		int diffOverlapHorizontal = horizontalRight > horizontalLeft ? horizontalRight - horizontalLeft : 0;
		overlapHorizontal = diffOverlapHorizontal > 0 ? Math.min(diffOverlapHorizontal, horizontalRight - boundLeft) : 0;
		if(overlapHorizontal != 0) {
			if(D > H) {
				horizontalUpper = H;
				horizontalLower = B;
				boundLower = F;
			}
			else {
				horizontalUpper = D;
				horizontalLower = F;
				boundLower = B;
			}
			int diffOverlapVertical = horizontalUpper > horizontalLower ? horizontalUpper - horizontalLower : 0;
			overlapVertical = diffOverlapVertical > 0 ? Math.min(diffOverlapVertical, horizontalUpper - boundLower) : 0;
		}
		return area1 + area2 - overlapHorizontal * overlapVertical;
	}
	
}
