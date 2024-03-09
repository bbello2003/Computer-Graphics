#include "Shader.h"

Shader::Shader()
{
    shader = 0;
}

Shader::~Shader()
{
    ClearShader();
}

void Shader::CreateFromFiles(const char *vertexLocation, const char *fragmentLocation)
{
    std::string vertexString = ReadFile(vertexLocation);
    std::string fragmentString = ReadFile(fragmentLocation);

    const char *vertexCode = vertexString.c_str();
    const char *fragmentCode = fragmentString.c_str();

    CompileShaders(vertexCode, fragmentCode);
}

std::string Shader::ReadFile(const char *fileLocation)
{
    std::string content;
    std::ifstream fileStream(fileLocation, std::ios::in);

    if (!fileStream.is_open())
    {
        printf("Failed to read %s!, File doesn't exist.\n", fileLocation);
        return "";
    }

    std::string line = "";

    while (!fileStream.eof())
    {
        std::getline(fileStream, line);
        content.append(line + "\n");
    }

    fileStream.close();
    return content;
}

void Shader::UseShader()
{
    glUseProgram(shader);
}

void Shader::ClearShader()
{
    if (shader != 0)
    {
        glDeleteProgram(shader);
        shader = 0;
    }
}

void Shader::CreateFromString(const char *vertexCode, const char *fragmentCode)
{
    CompileShaders(vertexCode, fragmentCode);
}

void Shader::CompileShaders(const char *vertexCode, const char *fragmentCode)
{
    shader = glCreateProgram();

    if (!shader)
    {
        printf("Error creating shader program!\n");
        return;
    }

    AddShader(shader, vertexCode, GL_VERTEX_SHADER);
    AddShader(shader, fragmentCode, GL_FRAGMENT_SHADER);

    GLint result = 0;
    GLchar elog[1024] = {0};

    glLinkProgram(shader);
    glGetProgramiv(shader, GL_LINK_STATUS, &result);

    if (!result)
    {
        glGetProgramInfoLog(shader, sizeof(elog), NULL, elog);
        printf("Error linking program: '%s'\n", elog);
        return;
    }

    glValidateProgram(shader);
    glGetProgramiv(shader, GL_VALIDATE_STATUS, &result);

    if (!result)
    {
        glGetProgramInfoLog(shader, sizeof(elog), NULL, elog);
        printf("Error validating program: '%s'\n", elog);
        return;
    }
}

void Shader::AddShader(GLuint theProgram, const char *shaderCode, GLenum shaderType)
{
    GLuint theShader = glCreateShader(shaderType);

    const GLchar *theCode[1];
    theCode[0] = shaderCode;

    GLint codeLength[1];
    codeLength[0] = strlen(shaderCode);

    glShaderSource(theShader, 1, theCode, codeLength);
    glCompileShader(theShader);

    GLint result = 0;
    GLchar elog[1024] = {0};

    glGetShaderiv(theShader, GL_COMPILE_STATUS, &result);

    if (!result)
    {
        glGetShaderInfoLog(theShader, sizeof(elog), NULL, elog);
        printf("Error compiling the %d shader: '%s'\n", shaderType, elog);
        return;
    }

    glAttachShader(theProgram, theShader);
}