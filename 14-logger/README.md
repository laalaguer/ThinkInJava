# This chapter in not part of Think in Java.

I am always quite curious about how high-level developers uses logs.
You know I always use `System.out.println()` to debug, but how to generate reports?
`java.util.logging` provides us a central way of printing out logs.

# Java Logger and its interfaces.
`Logger`: An instance of log facility, generates log.
`LogRecord`: A log.
`Filter`: Determines if the log can be forwarded based on the rules.
`Handler`: Deliver the `LogRecord` to out-side services, like disk, HTML page, etc.

# To be continued in the future.