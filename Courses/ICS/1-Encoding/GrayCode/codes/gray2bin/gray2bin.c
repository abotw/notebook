// gray2bin.c
// Convert Gray code string to binary string.
// Usage: ./gray2bin 1101 => 1001

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// XOR two characters ('0' or '1') as binary bits
char xor_bit(char a, char b) {
    return (a == b) ? '0' : '1';
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <gray-string>\n", argv[0]);
        return 1;
    }

    char *gray = argv[1];
    size_t len = strlen(gray);

    // Validate input
    for (size_t i = 0; i < len; ++i) {
        if (gray[i] != '0' && gray[i] != '1') {
            fprintf(stderr, "Error: Input must be a binary string.\n");
            return 1;
        }
    }

    // Allocate output string
    char *bin = malloc(len + 1);
    if (!bin) {
        perror("malloc");
        return 1;
    }

    // MSB remains the same
    bin[0] = gray[0];

    // Recover binary bits by accumulating XORs
    for (size_t i = 1; i < len; ++i) {
        bin[i] = xor_bit(bin[i - 1], gray[i]);
    }

    bin[len] = '\0';
    printf("%s\n", bin);

    free(bin);
    return 0;
}
