#include <stdio.h>
#include <stdlib.h>

int rc = 0, wc = 0;

int main() {
    int ch;
    printf("1.Read 2.Write 3.Stop Read 4.Stop Write 5.Exit\n");
    while(1) {
        printf("Choice: "); scanf("%d", &ch);
        switch(ch) {
            case 1:
                if (wc == 0) printf("Reader %d reading\n", ++rc);
                else printf("Writer busy\n");
                break;
            case 2:
                if (wc == 0 && rc == 0) { wc = 1; printf("Writer writing\n"); } 
                else printf("System busy\n");
                break;
            case 3:
                if (rc > 0) printf("Reader %d stopped\n", rc--);
                else printf("No readers\n");
                break;
            case 4:
                if (wc == 1) { wc = 0; printf("Writer stopped\n"); } 
                else printf("No writer\n");
                break;
            case 5: exit(0);
        }
    }
}

// Output
// 1.Read 2.Write 3.Stop Read 4.Stop Write 5.Exit
// Choice: 1
// Reader 1 reading
// Choice: 2
// System busy
// Choice: 1
// Reader 2 reading
// Choice: 3
// Reader 2 stopped
// Choice: 2
// System busy
// Choice: 4
// No writer
// Choice: 2
// System busy
// Choice: 3
// Reader 1 stopped
// Choice: 2
// Writer writing
// Choice: 5
