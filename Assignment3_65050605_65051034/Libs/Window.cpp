#include "Window.h"

Window::Window()
{
    width = 800;
    height = 600;
    glfwMajorVersion = 3;
    glfwMinorVersion = 1;
}

Window::Window(GLint windowWidth, GLint windowHeight, GLint majorVersion, GLint minorVersion)
{
    width = windowWidth;
    height = windowHeight;
    glfwMajorVersion = majorVersion;
    glfwMinorVersion = minorVersion;
}

Window::~Window()
{
    glfwDestroyWindow(mainWindow);
    glfwTerminate();
}

int Window::initialise()
{
    // init GLFW
    if (!glfwInit())
    {
        printf("GLFW initialisation failed!");
        glfwTerminate();
        return 1;
    }

    // Setup GLFW window properties
    // OpenGL version (using 3.1)
    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, glfwMajorVersion);
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, glfwMinorVersion);

    // Core Profile = No Backwards Compatibility
    glfwWindowHint(GLFW_OPENGL_ANY_PROFILE, GLFW_OPENGL_CORE_PROFILE);
    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
    // Allow forward compatibility
    glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);

    mainWindow = glfwCreateWindow(width, height, "MY PRECIOUS MOMENT", NULL, NULL);

    if (!mainWindow)
    {
        printf("GLFW window creation failed!");
        glfwTerminate();
        return 1;
    }

    // Get Buffer size information
    glfwGetFramebufferSize(mainWindow, &bufferWidth, &bufferHeight);

    // Set context for GLEW to use
    glfwMakeContextCurrent(mainWindow);

    // Allow modern extension features
    glewExperimental = GL_TRUE;

    if (glewInit() != GLEW_OK)
    {
        printf("GLEW initialisation failed!");
        glfwDestroyWindow(mainWindow);
        glfwTerminate();
        return 1;
    }

    glEnable(GL_DEPTH_TEST);

    // Setup Viewport size
    glViewport(0, 0, bufferWidth, bufferHeight);

    return 0;
}