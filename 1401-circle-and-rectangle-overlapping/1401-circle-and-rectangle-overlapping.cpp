class Solution {
public:
    bool checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xi = max(x1, min(xCenter, x2));
        int yi = max(y1, min(yCenter, y2));

        int x = pow(xi-xCenter, 2)+pow(yi-yCenter, 2);
        int y = sqrt(x);

        if(y<=radius){
            return true;
        }
        else if(y>radius){
            return false;
        }
        return false;
    }
};