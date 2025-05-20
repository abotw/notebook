// bin2gray.c
// Convert binary string to Gray code string.
// Usage: ./bin2gray 1001 => 1101

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// XOR two characters ('0' or '1') as binary bits
char xor_bit(char a, char b) {
    return (a == b) ? '0' : '1';
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <binary-string>\n", argv[0]);
        return 1;
    }

    char *bin = argv[1];
    size_t len = strlen(bin);

    // Validate input
    for (size_t i = 0; i < len; ++i) {
        if (bin[i] != '0' && bin[i] != '1') {
            fprintf(stderr, "Error: Input must be a binary string.\n");
            return 1;
        }
    }

    // Allocate output string
    char *gray = malloc(len + 1);
    if (!gray) {
        perror("malloc");
        return 1;
    }

    // MSB remains the same
    gray[0] = bin[0];

    // XOR adjacent bits
    for (size_t i = 1; i < len; ++i) {
        gray[i] = xor_bit(bin[i - 1], bin[i]);
    }

    gray[len] = '\0';
    printf("%s\n", gray);

    free(gray);
    return 0;
}
