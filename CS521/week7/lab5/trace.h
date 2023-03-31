/**
 * @file
 *
 * Helps facilitate debugging by providing basic logging functionality. Unlike
 * printf-style debugging, the log messages can be enabled/disabled by changing
 * the value of TRACE.
 */

#ifndef _TRACE_H_
#define _TRACE_H_

#include <stdio.h>
#include <unistd.h>

/**
 * If TRACE is not set, it will be enabled by default.
 */
#ifndef TRACE_ON
#define TRACE_ON 1
#endif

/**
 * TRACE_COLOR determines whether debug output is colorized. It is enabled by
 * default.
 */
#ifndef TRACE_COLOR
#define TRACE_COLOR 1
#endif

#if TRACE_COLOR
#define TRACE_COLOR_RED    "\033[0;31m"
#define TRACE_COLOR_YELLOW "\033[1;33m"
#define TRACE_COLOR_BLUE   "\033[1;34m"
#define TRACE_COLOR_RESET  "\033[0m"
#endif

/**
 * Prints a formatted trace.
 */
#define TRACE(fmt, ...) \
    do { \
        if (TRACE_ON) { \
            if (TRACE_COLOR) { \
                if (isatty(STDERR_FILENO)) { \
                    fprintf(stderr, "%s%s%s %s%s()%s: " fmt "\n", \
                            TRACE_COLOR_YELLOW, "[TRACE]", TRACE_COLOR_RESET, \
                            TRACE_COLOR_BLUE, __func__, TRACE_COLOR_RESET, \
                            __VA_ARGS__); \
                    break; \
                } \
                fprintf(stderr, "%s:%d:%s(): " fmt, __FILE__, \
                        __LINE__, __func__, __VA_ARGS__); \
            } \
        } \
    } while (0)

#endif